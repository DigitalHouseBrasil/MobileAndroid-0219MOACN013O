package br.com.digitalhouse.firebaseapp.register.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import br.com.digitalhouse.firebaseapp.R;
import br.com.digitalhouse.firebaseapp.home.view.HomeActivity;
import br.com.digitalhouse.firebaseapp.util.AppUtil;
import de.hdodenhof.circleimageview.CircleImageView;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

public class RegisterActivity extends AppCompatActivity {
    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private Button btnRegister;
    private CircleImageView imageView;
    private ProgressBar progressBar;
    private static final int PERMISSION_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btn_register);
        textInputLayoutName = findViewById(R.id.textinput_name);
        textInputLayoutEmail = findViewById(R.id.textinput_email);
        textInputLayoutPassword = findViewById(R.id.textinput_password);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.imageview_user_login);

        btnRegister.setOnClickListener(v -> {
            String email = textInputLayoutEmail.getEditText().getText().toString();
            String password = textInputLayoutPassword.getEditText().getText().toString();

            // Se email e senha são validos tentamos o registro no firebase
            if (validar(email, password)) {
                registrarUsuario(email, password);
            }
        });

        imageView.setOnClickListener(view -> {
            int permissionCamera = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

            int permissionStorage = ContextCompat
                    .checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (permissionCamera == PackageManager.PERMISSION_GRANTED &&
                    permissionStorage == PackageManager.PERMISSION_GRANTED) {
                EasyImage.openCameraForImage(this, MODE_PRIVATE);
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISSION_CODE);
            }
        });

    }

    private void registrarUsuario(String email, String password) {
        progressBar.setVisibility(View.VISIBLE);

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {

                    // seta o loading para true para dar feedback ao uauário, que terminou o cadastro
                    progressBar.setVisibility(View.GONE);

                    // Se conseguiu se registrar com sucesso vamos para a home
                    if (task.isSuccessful()) {
                        AppUtil.salvarIdUsuario(RegisterActivity.this, FirebaseAuth.getInstance().getCurrentUser().getUid());
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        finish();
                    } else {

                        // Se deu algum erro mostramos para o usuário a mensagem
                        Snackbar.make(btnRegister, task.getException().getMessage(), Snackbar.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
    }

    // Essa validação pode ficar na view em vez do viewmodel, pois ela trata os elementos da tela
    private boolean validar(String email, String password) {
        if (email.isEmpty()) {
            textInputLayoutEmail.setError("Email não pode ser vazio");
            textInputLayoutEmail.requestFocus();
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            textInputLayoutEmail.setError("Email inválido");
            textInputLayoutEmail.requestFocus();
            return false;
        }

        if (password.isEmpty()) {
            textInputLayoutPassword.setError("Senha não pode ser vazio");
            textInputLayoutPassword.requestFocus();
            return false;
        }

        if (password.length() < 6) {
            textInputLayoutPassword.setError("Senha deve ser maior qeu 6 caracters");
            textInputLayoutPassword.requestFocus();
            return false;
        }

        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_CODE) {
            EasyImage.openCameraForImage(this, MODE_PRIVATE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagesPicked(@NonNull List<File> imageFiles, EasyImage.ImageSource source, int type) {
                for (File file : imageFiles) {
                    InputStream stream = null;
                    try {
                        stream = new FileInputStream(file);
                        salvarImagemFirebase(stream, "imagem-perfil"/*mediaFile.getFile().getName()*/);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }

    private void salvarImagemFirebase(InputStream stream, String nome) {

        StorageReference storage = FirebaseStorage
                .getInstance()
                .getReference()
                .child(AppUtil.getIdUsuario(this) + "/image/profile/imagem-perfil");

        UploadTask uploadTask = storage.putStream(stream);

        uploadTask.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                storage.getDownloadUrl()
                        .addOnSuccessListener(uri -> {
                            Picasso.get()
                                    .load(uri)
                                    .rotate(90)
                                    .into(imageView);
                        });
            }
        });
    }
}
