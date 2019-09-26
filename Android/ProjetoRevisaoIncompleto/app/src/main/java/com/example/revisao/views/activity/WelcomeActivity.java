package com.example.revisao.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.revisao.R;

public class WelcomeActivity extends AppCompatActivity {
    private TextView txtBoasVindas;
    private Button btnComecar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initViews();

        //Implementar a lógica de recebimento de dados e setar o nome no textView

        btnComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
            }
        });


    }

    private void initViews() {
        txtBoasVindas = findViewById(R.id.textViewBemVindo);
        btnComecar = findViewById(R.id.btnComecar);
    }
}
