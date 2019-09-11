package com.example.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class HomeActivity extends AppCompatActivity {
    private TextInputLayout inputLayoutMusica;
    private FloatingActionButton btnAdd;
    private TextView txtNomeMusica;
    private Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        inputLayoutMusica = findViewById(R.id.textInputLayoutMusica);
        btnAdd = findViewById(R.id.floatingActionButtonAdd);
        txtNomeMusica = findViewById(R.id.textViewNomeMusica);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String musica = inputLayoutMusica.getEditText().getText().toString();

                if (musica.isEmpty() || musica == ""){
                    inputLayoutMusica.setError("O campo não pode ser nulo");

                }else{

                    txtNomeMusica.setText(musica);
                    Snackbar.make(inputLayoutMusica, "Música adicionada", Snackbar.LENGTH_LONG).show();

                }
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, FinalizarActivity.class));
            }
        });
    }
}
