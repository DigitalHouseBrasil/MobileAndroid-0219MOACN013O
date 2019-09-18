package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnPraiaALmada;
    private Button btnPraiaJusta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //chamada do método que inicializa as views
        initView();

        btnPraiaALmada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chamada do método que recarrega o Fragment da praia da Almada
                recarregaFragment(new AlmadaFragment());
            }
        });

        btnPraiaJusta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chamada do método que recarrega o Fragment da praia da Almada
                recarregaFragment(new JustaFragment());
            }
        });
    }

    //Método que inicializa as views
    public void initView() {
        btnPraiaALmada = findViewById(R.id.buttonPraia1);
        btnPraiaJusta = findViewById(R.id.buttonPraia2);
    }


    //Método que recarrrega um Fragment
    public void recarregaFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
}
