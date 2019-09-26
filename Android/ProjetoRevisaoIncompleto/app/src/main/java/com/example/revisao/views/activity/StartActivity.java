package com.example.revisao.views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.revisao.R;
import com.google.android.material.textfield.TextInputLayout;

public class StartActivity extends AppCompatActivity {

    private TextInputLayout inputNome;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initView();

        //Implementar a lógica de ação do botão enviar

    }

    private void initView(){
        inputNome = findViewById(R.id.textInputLayoutNome);
        btnEnviar = findViewById(R.id.btnEnviar);
    }

    //Implementaro a lógica do método de envio de dados para activity
    private void enviaNomeActivity(String nome){

    }

}
