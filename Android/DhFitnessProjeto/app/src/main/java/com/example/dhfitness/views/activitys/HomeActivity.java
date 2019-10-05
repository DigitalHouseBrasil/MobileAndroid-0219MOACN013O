package com.example.dhfitness.views.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dhfitness.R;
import com.example.dhfitness.model.Usuario;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import static com.example.dhfitness.views.activitys.LoginActivity.USER_KEY;

public class HomeActivity extends AppCompatActivity {
    private TextView txtHome;
    private TextView txtIdade;
    private TextView txtAltura;
    private TextView txtPeso;
    private Button btnVamosLa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();

        Intent intent = getIntent();
        final Usuario usario = setInformacoes(intent);

        btnVamosLa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviaDados(usario);
            }
        });
    }

    private void initViews() {
        txtHome = findViewById(R.id.textViewHome);
        txtIdade = findViewById(R.id.textViewIdade);
        txtPeso = findViewById(R.id.textViewPeso);
        txtAltura = findViewById(R.id.textViewAltura);
        btnVamosLa = findViewById(R.id.btnVamosLa);
    }

    private Usuario setInformacoes(Intent intent){
        Usuario usuario;

        if (getIntent() != null && intent.getExtras() != null) {

            usuario = (Usuario) getIntent().getParcelableExtra(USER_KEY);

            txtHome.setText("Seja bem vindo " + usuario.getNome() + " ! Esse é um aplicativo que\n" +
                    "te ajuda a saber e calcular o seu Indice de Massa \n" +
                    "Corporal");

            String peso = String.valueOf(usuario.getPeso());
            String altura = String.valueOf(usuario.getAltura());
            String idade = String.valueOf(usuario.getIdade());

            txtIdade.setText(idade);
            txtPeso.setText(peso);
            txtAltura.setText(altura);

            return usuario;
        }

        return usuario = new Usuario();
    }

    private void enviaDados(Usuario usuario){

        Intent intent = new Intent(HomeActivity.this, ResultadosActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(USER_KEY, usuario);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
