package com.example.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class FinalizarActivity extends AppCompatActivity {

    private TextInputLayout inputNome;
    private TextView textNome;
    private Button btnNovaMusica;
    private FloatingActionButton btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar);

        inputNome = findViewById(R.id.textInputLayoutNome);
        textNome = findViewById(R.id.textViewNome);
        btnNovaMusica = findViewById(R.id.btnNovaMusica);
        btnCheck = findViewById(R.id.floatingActionButtonCheck);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Pegando o valor digitado no TextInputLayout
                String nome = inputNome.getEditText().getText().toString();

                if (nome.isEmpty() || nome == ""){
                    //Snackbar mostrando mensagem
                    Snackbar.make(inputNome, "Preencha o campo nome", Snackbar.LENGTH_LONG).show();
                }else{

                    //Seta o valor para o componente TextView
                    textNome.setText("Obrigado " +nome+ " !");
                }
            }
        });

        btnNovaMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Criando uma nova intenção para voltar para a tela de Home
                startActivity(new Intent(FinalizarActivity.this, HomeActivity.class));
            }
        });


    }
}
