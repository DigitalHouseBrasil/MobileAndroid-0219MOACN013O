package com.example.dhfitness.views.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dhfitness.R;
import com.example.dhfitness.interfaces.Comunicador;
import com.example.dhfitness.model.Usuario;
import com.example.dhfitness.views.fragments.PrimeiroFragment;
import com.example.dhfitness.views.fragments.SegundoFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.dhfitness.views.activitys.LoginActivity.USER_KEY;

public class ResultadosActivity extends AppCompatActivity implements Comunicador {
    public static final String RESULTADO_KEY = "resultado";
    private FloatingActionButton btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        btnSair = findViewById(R.id.floatingActionButtonSair);

        Intent intent = getIntent();
        getInformationUser(intent);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultadosActivity.this, LoginActivity.class));
            }
        });

    }

    private void replaceFragment(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    private void sendUserToFragment(Usuario usuario){
        Bundle bundle = new Bundle();
        bundle.putParcelable(USER_KEY,usuario);

        Fragment primeiroFragment = new PrimeiroFragment();
        primeiroFragment.setArguments(bundle);

        replaceFragment(R.id.container2, primeiroFragment);
    }

    private void getInformationUser(Intent intent){

        if (getIntent() != null && intent.getExtras() != null) {

            Usuario usuario = (Usuario) getIntent().getParcelableExtra(USER_KEY);

           sendUserToFragment(usuario);
        }
    }

    @Override
    public void recebeResultadoImc(double resultado) {
        Bundle bundle = new Bundle();
        bundle.putDouble(RESULTADO_KEY, resultado);

        Fragment segundoFragment = new SegundoFragment();
        segundoFragment.setArguments(bundle);

        replaceFragment(R.id.container1, segundoFragment);
    }
}
