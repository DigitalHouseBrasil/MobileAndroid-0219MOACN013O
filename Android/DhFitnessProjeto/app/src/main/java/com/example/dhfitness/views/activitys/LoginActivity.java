package com.example.dhfitness.views.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dhfitness.R;
import com.example.dhfitness.model.Usuario;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout inputNome;
    private TextInputLayout inputIdade;
    private TextInputLayout inputPeso;
    private TextInputLayout inputAltura;
    private Button btnComecar;
    public static final String USER_KEY = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        btnComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!inputNome.getEditText().getText().toString().isEmpty() &&
                        !inputIdade.getEditText().getText().toString().isEmpty() &&
                        !inputAltura.getEditText().getText().toString().isEmpty() &&
                        !inputPeso.getEditText().getText().toString().isEmpty()) {

                    String nome = inputNome.getEditText().getText().toString();
                    int idade = Integer.parseInt(inputIdade.getEditText().getText().toString());
                    float altura = Float.parseFloat(inputAltura.getEditText().getText().toString());
                    float peso = Float.parseFloat(inputPeso.getEditText().getText().toString());

                    verificaDadosRecebidos(nome, idade, altura, peso);

                } else {
                    Snackbar.make(inputNome, "Preencha os campos vazios!", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initView() {
        inputNome = findViewById(R.id.textInputLayoutNome);
        inputIdade = findViewById(R.id.textInputLayoutIdade);
        inputAltura = findViewById(R.id.textInputLayoutAltura);
        inputPeso = findViewById(R.id.textInputLayoutPeso);
        btnComecar = findViewById(R.id.btnComecar);
    }

    private void enviaDadosUsuario(Usuario usuario) {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);

        Bundle bundle = new Bundle();
        bundle.putParcelable(USER_KEY, usuario);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    private void verificaDadosRecebidos(String nome, int idade, float altura, float peso) {
        if (!nome.isEmpty() && idade != 0 && altura != 0 && peso != 0) {
            Usuario usuario = new Usuario(nome, idade, altura, peso);
            enviaDadosUsuario(usuario);
        } else {
            Snackbar.make(inputNome, "Preencha os campos!", Snackbar.LENGTH_LONG).show();
        }
    }
}
