package com.example.revisaoactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Comunicador{
    public static final String MSG_KEY = "mensagem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(R.id.container2, new PrimeiroFragment());
    }

    @Override
    public void receberMensagem(String mensagem) {
        Bundle bundle = new Bundle();
        bundle.putString(MSG_KEY, mensagem);
        Fragment segundoFragment = new SegundoFragment();
        segundoFragment.setArguments(bundle);
        replaceFragment(R.id.container1, segundoFragment);
    }

    private void replaceFragment(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

}
