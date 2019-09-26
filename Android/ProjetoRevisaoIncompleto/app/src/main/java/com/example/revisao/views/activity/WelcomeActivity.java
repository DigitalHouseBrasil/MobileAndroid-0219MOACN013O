package com.example.revisao.views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.revisao.R;

import static com.example.revisao.views.activity.StartActivity.NOME_KEY;

public class WelcomeActivity extends AppCompatActivity {
    private TextView txtBoasVindas;
    private Button btnComecar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initViews();

        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            String nome = bundle.getString(NOME_KEY);

            txtBoasVindas.setText("Seja bem-vindo "+nome+
                    " esse é um aplicativo para revisão!");

            btnComecar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
                }
            });
        }

    }

    private void initViews(){
        txtBoasVindas = findViewById(R.id.textViewBemVindo);
        btnComecar = findViewById(R.id.btnComecar);
    }
}
