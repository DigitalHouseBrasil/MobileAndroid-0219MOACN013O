package com.example.comunicacaoactivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout inputNome;
    private TextInputLayout inputTelefone;
    private FloatingActionButton btnAdd;

   public static final String NOME_KEY = "nome";
   public static final String TELEFONE_KEY = "telefone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNome = findViewById(R.id.textInputLayoutNome);
        inputTelefone = findViewById(R.id.textInputLayoutTelefone);
        btnAdd = findViewById(R.id.floatingActionButtonAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = inputNome.getEditText().getText().toString();
                String telefone = inputTelefone.getEditText().getText().toString();

                if (!nome.isEmpty() && !telefone.isEmpty()){
                    //Mando para outra activity os dados

                    //Criando uma nova instancia do tipo Intent
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);

                    //Criando uma nova instancia do Bundle
                    Bundle bundle = new Bundle();

                    //Passando os dados para o bundle
                    bundle.putString(NOME_KEY, nome);
                    bundle.putString(TELEFONE_KEY, telefone);

                    //Passo bundle para a intent
                    intent.putExtras(bundle);

                    //Passo a intent para o startActivity
                    startActivity(intent);

                }else{
                    inputNome.setError("Preencha o campo nome!");
                    inputTelefone.setError("Preencha o campo telefone!");
                }

            }
        });
    }
}
