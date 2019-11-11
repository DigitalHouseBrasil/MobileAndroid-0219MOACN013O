package br.com.digitalhouse.firebaseapp.register.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import br.com.digitalhouse.firebaseapp.R;
import br.com.digitalhouse.firebaseapp.home.view.HomeActivity;
import br.com.digitalhouse.firebaseapp.register.viewmodel.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity {
    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private Button btnRegister;
    private ProgressBar progressBar;
    private RegisterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btn_register);
        textInputLayoutName = findViewById(R.id.textinput_name);
        textInputLayoutEmail = findViewById(R.id.textinput_email);
        textInputLayoutPassword = findViewById(R.id.textinput_password);
        progressBar = findViewById(R.id.progressBar);
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);

        btnRegister.setOnClickListener(v -> {
            String email = textInputLayoutEmail.getEditText().getText().toString();
            String password = textInputLayoutPassword.getEditText().getText().toString();

            // Se email e senha são validos tentamos o registro no firebase
            if (validar(email, password)) {
                viewModel.registrar(email, password);
            }
        });

        //Se registrou com sucesso vamos direcionar para tela  HOME
        viewModel.getIsLogged().observe(this, isLogged -> {
            if (isLogged) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                finish();
            }
        });

        // Se deu algum erro mostramos na tela
        viewModel.getLiveDataError().observe(this, throwable -> {
            String error = throwable.getMessage();
            Snackbar.make(btnRegister, error, Snackbar.LENGTH_LONG).show();
        });


        // Mostramos o loading para feeed back ao usuário enquanto carega o login
        viewModel.getIsLoading().observe(this, loading -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
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
