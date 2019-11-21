package br.com.digitalhouse.firebaseapp.jaum.register.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import br.com.digitalhouse.firebaseapp.R;
import br.com.digitalhouse.firebaseapp.jaum.home.view.HomeActivity;
import br.com.digitalhouse.firebaseapp.jaum.util.AppUtil;

public class RegisterActivity extends AppCompatActivity {
    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private Button btnRegister;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btn_register);
        textInputLayoutName = findViewById(R.id.textinput_name);
        textInputLayoutEmail = findViewById(R.id.textinput_email);
        textInputLayoutPassword = findViewById(R.id.textinput_password);
        progressBar = findViewById(R.id.progressBar);

        btnRegister.setOnClickListener(v -> {
            String email = textInputLayoutEmail.getEditText().getText().toString();
            String password = textInputLayoutPassword.getEditText().getText().toString();

            // Se email e senha são validos tentamos o registro no firebase
            if (validar(email, password)) {
                registrarUsuario(email, password);
            }
        });
    }

    private void registrarUsuario(String email, String password) {
        progressBar.setVisibility(View.VISIBLE);

        // TODO: cadastro co firebase via email e senha
        FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {

                        AppUtil.salvarIdUsuario(RegisterActivity.this, FirebaseAuth.getInstance().getCurrentUser().getUid());
                        startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                        finish();

                    } else {
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
}
