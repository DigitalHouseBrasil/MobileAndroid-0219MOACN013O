package com.example.comunicacaofragments.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.comunicacaofragments.R;
import com.example.comunicacaofragments.interfaces.Comunicador;
import com.example.comunicacaofragments.model.SistemaOperacional;

//Implementação da interface Comunicador
public class MainActivity extends AppCompatActivity implements Comunicador {
    //Criação da constante
    public static final String SO_KEY = "SO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Método que recarrega o primeiroFragment no container2
        replaceFragment(R.id.container2, new PrimeiroFragment());
    }

    //Sobrescrita do método implementado pela interface
    @Override
    public void recebeMensagem(SistemaOperacional sistema) {
        //Método que envia as informações para o segundo fragmento
        setBundleToFragment(sistema, SO_KEY);
    }

    //Método que recarrega o um fragmento em um container
    private void replaceFragment(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    //Método que envia as inforções para um fragmento
    private void setBundleToFragment(SistemaOperacional so, String CHAVE){
        //Criação do bundle
        Bundle bundle = new Bundle();

        //Setando um parcelable para o bundle através de chave e valor(valor objeto)
        bundle.putParcelable(CHAVE, so);

        //Criação do segundo fragmento
        Fragment segundoFragment = new SegundoFragment();

        //setando os valores do bundle para ser enviado para o segundo fragmento através do método setArguments()
        segundoFragment.setArguments(bundle);

        //Chamada do método que recarrega um fragmento em um container
        replaceFragment(R.id.container1, segundoFragment);
    }
}
