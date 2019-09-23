package com.example.carrosfamosos.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.carrosfamosos.R;
import com.example.carrosfamosos.interfaces.Comunicador;
import com.example.carrosfamosos.model.Carro;

public class CarrosActivity extends AppCompatActivity implements Comunicador {

    public static final String CARRO_KEY = "carro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros_activiry);

        replaceFragment(R.id.container_dois, new FragmentBotao());
    }

    private void replaceFragment(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    private void setBundleToFragment(Carro carro, String CHAVE){
        Bundle bundle = new Bundle();

        bundle.putParcelable(CHAVE, carro);

        Fragment segundoFragment = new FragmentCarro();

        segundoFragment.setArguments(bundle);

        replaceFragment(R.id.container_um, segundoFragment);
    }

    @Override
    public void recebeMensagem(Carro carro) {
        setBundleToFragment(carro, CARRO_KEY);
    }
}
