package br.com.digitalhouse.firebaseapp.register.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import br.com.digitalhouse.firebaseapp.R;
import br.com.digitalhouse.firebaseapp.home.view.HomeActivity;
import br.com.digitalhouse.firebaseapp.util.AppUtil;

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
}
