package com.example.dhfitness.views.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dhfitness.R;
import com.example.dhfitness.interfaces.Comunicador;
import com.example.dhfitness.model.Usuario;

import static com.example.dhfitness.views.activitys.LoginActivity.USER_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrimeiroFragment extends Fragment {
    private Button btnCalcular;
    private Button btnInformacoes;
    private Comunicador comunicador;
    private double resultado;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            comunicador = (Comunicador) context;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public PrimeiroFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primeiro, container, false);

        initVIews(view);

        if (!getArguments().isEmpty()) {
            Usuario usuario = getArguments().getParcelable(USER_KEY);

            double peso = usuario.getPeso();
            double altura = usuario.getAltura();

            resultado = calculaImc(peso, altura);
        }

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comunicador.recebeResultadoImc(resultado);
            }
        });

        btnInformacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comunicador.recebeResultadoImc(0.0);
            }
        });

        return view;
    }

    private void initVIews(View view) {
        btnCalcular = view.findViewById(R.id.btnCalcular);
        btnInformacoes = view.findViewById(R.id.btnInformacoes);
    }

    private double calculaImc(double peso, double altura) {
        double resultado = peso / (altura * altura);
        return resultado;
    }

}
