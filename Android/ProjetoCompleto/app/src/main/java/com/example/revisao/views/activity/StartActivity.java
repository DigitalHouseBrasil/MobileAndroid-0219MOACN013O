package com.example.revisao.views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.revisao.R;
import com.google.android.material.textfield.TextInputLayout;

public class StartActivity extends AppCompatActivity {
    public static final String NOME_KEY = "nome";
    private TextInputLayout inputNome;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initView();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = inputNome.getEditText().getText().toString();

                if (!nome.isEmpty()){
                    enviaNomeActivity(nome);
                }else{
                    inputNome.setError("Preencha o campo nome");
                }
            }
        });


    }

    private void initView(){
        inputNome = findViewById(R.id.textInputLayoutNome);
        btnEnviar = findViewById(R.id.btnEnviar);
    }

    private void enviaNomeActivity(String nome){
        Intent intent = new Intent(StartActivity.this, WelcomeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(NOME_KEY, nome);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
