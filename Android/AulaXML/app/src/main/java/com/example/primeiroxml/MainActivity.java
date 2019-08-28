package com.example.primeiroxml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variaveis
    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Valores das variaveis conectando com XML
        textView = findViewById(R.id.text_id);
        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.button_id);

        //capturando valor do usuario
        final Editable nome = editText.getText();

        //adicionando click no botão
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mensagem Toast com valor do usuario
                Toast.makeText(getApplicationContext(),nome, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
