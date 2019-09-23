package com.example.carrosfamosos.view;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.carrosfamosos.R;

public class CadastroActivity extends AppCompatActivity {

    private TextInputLayout textName;
    private TextInputLayout textEmail;
    private TextInputLayout textSenha;
    private Button btn_entrar;
    public final static String NOME_KEY = "nome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        initView();

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = textName.getEditText().getText().toString();
                String senha = textSenha.getEditText().getText().toString();
                String email = textEmail.getEditText().getText().toString();


                if(!nome.isEmpty() && !senha.isEmpty() && !email.isEmpty() ){


                    Intent intent = new Intent(CadastroActivity.this, BemVindoActivity.class);

                    Bundle bundle = new Bundle();

                    bundle.putString(NOME_KEY, nome);

                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    textName.setError("Preencha o campo NOME!");
                    textSenha.setError("Preencha o campo SENHA!");
                    textEmail.setError("Preencha o campo EMAIL!");
                }
            }
        });

    }


    public void initView(){
        textName = findViewById(R.id.input_text_name);
        textSenha = findViewById(R.id.text_input_senha);
        textEmail = findViewById(R.id.text_input_email);
        btn_entrar = findViewById(R.id.btn_entrar);
    }
}
