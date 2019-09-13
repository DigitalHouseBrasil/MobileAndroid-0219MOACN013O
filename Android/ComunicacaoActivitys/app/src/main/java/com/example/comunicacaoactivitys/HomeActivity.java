package com.example.comunicacaoactivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;

import static com.example.comunicacaoactivitys.MainActivity.NOME_KEY;
import static com.example.comunicacaoactivitys.MainActivity.TELEFONE_KEY;


public class HomeActivity extends AppCompatActivity {
    private TextView txtNome;
    private TextView txtTelefone;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtNome = findViewById(R.id.textViewNome);
        txtTelefone = findViewById(R.id.textViewTelefone);
        btnVoltar = findViewById(R.id.buttonVoltar);

        //Criando uma variavel do tipo Intent que recebe um getIntent()
        Intent intent = getIntent();

        //Verificação para saber se o intent que está chegando não é null e não possui dados nulos
        if (getIntent() != null && intent.getExtras() != null ){

            //Variavel do tipo bundle que recebe as informações vindas do Intent
            Bundle bundle = intent.getExtras();

            //Atribuição dos valores recebidos da outra activity para as variáveis através do bundle.getString e a constante para referenciar o valor
            String nome = bundle.getString(NOME_KEY);
            String telefone = bundle.getString(TELEFONE_KEY);

            //setando as variaveis com valores para os respectivos TextView
            txtNome.setText(nome);
            txtTelefone.setText(telefone);

        }else{
            Snackbar.make(txtNome, "Não a dados!", Snackbar.LENGTH_LONG).show();
        }


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });



    }
}