package com.example.tarefacadastrointroducaoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextEndereco;
    private EditText editTextProfissao;
    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.edit_text_nome);
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextEndereco = findViewById(R.id.edit_text_endereco);
        editTextProfissao = findViewById(R.id.edit_text_profissao);
        buttonEnviar = findViewById(R.id.button_enviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String endereco = editTextEndereco.getText().toString();
                String profissao = editTextProfissao.getText().toString();

                if (nome.equals("")) {
                    Toast.makeText(MainActivity.this, "Nome não pode ser vazio", Toast.LENGTH_SHORT).show();
                } else if (email.equals("")) {
                    Toast.makeText(MainActivity.this, "Email não pode ser vazio", Toast.LENGTH_SHORT).show();
                } else if (endereco.equals("")) {
                    Toast.makeText(MainActivity.this, "Endereço não pode ser vazio", Toast.LENGTH_SHORT).show();
                } else if (profissao.equals("")) {
                    Toast.makeText(MainActivity.this, "Profissão não pode ser vazio", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Dados OK!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
