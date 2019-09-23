package com.example.carrosfamosos.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.carrosfamosos.R;

import static com.example.carrosfamosos.view.CadastroActivity.NOME_KEY;

public class BemVindoActivity extends AppCompatActivity {

    private TextView textViewName;
    private Button btn_vamos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        initView();

        btn_vamos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BemVindoActivity.this, CarrosActivity.class));
            }
        });
        Intent intent = getIntent();

        if(getIntent() != null && intent.getExtras() != null){

            Bundle bundle = intent.getExtras();

            String nome = bundle.getString(NOME_KEY);

            textViewName.setText(nome);

        }
    }


    public void initView(){
        textViewName = findViewById(R.id.text_name);
        btn_vamos = findViewById(R.id.btn_vamos);
    }
}
