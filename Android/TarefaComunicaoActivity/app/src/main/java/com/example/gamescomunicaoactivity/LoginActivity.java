package com.example.gamescomunicaoactivity;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout text_input_name;
    TextInputLayout text_input_senha;
    Button btn_enviar;
    public static final String NOME_KEY = "nome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        text_input_name = findViewById(R.id.text_input_name);
        text_input_senha = findViewById(R.id.text_input_senha);
        btn_enviar = findViewById(R.id.btn_login);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = text_input_name.getEditText().getText().toString();

                if(!nome.isEmpty()){

                    Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(NOME_KEY, nome);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }else{
                    text_input_name.setError("Preencha o campo nome!");
                    text_input_senha.setError("Preencha o campo senha!");
                }
            }
        });
    }

}
