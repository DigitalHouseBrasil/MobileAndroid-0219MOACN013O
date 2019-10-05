package com.example.dhfitness.views.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dhfitness.R;
import com.example.dhfitness.model.Usuario;

import java.text.DecimalFormat;

import static com.example.dhfitness.views.activitys.LoginActivity.USER_KEY;
import static com.example.dhfitness.views.activitys.ResultadosActivity.RESULTADO_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class SegundoFragment extends Fragment {
    private TextView txtResultado;
    private DecimalFormat formato = new DecimalFormat("#.##");
    private ImageView imagem;

    public SegundoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_segundo, container, false);

        initViews(view);

        if (!getArguments().isEmpty() && getArguments() != null) {
            double resultado = getArguments().getDouble(RESULTADO_KEY);
            verificaResultado(resultado);
        }

        return view;
    }

    private void initViews(View view) {
        txtResultado = view.findViewById(R.id.textViewResultado);
        imagem = view.findViewById(R.id.circleImageView);
    }

    private void verificaResultado(double resultado) {
        if (resultado > 1.1 && resultado < 18.5) {

            txtResultado.setText("Seu IMC é de: " + formato.format(resultado) + " e sua classificação é MAGREZA");

        } else if (resultado > 18.5 && resultado < 24.9) {

            txtResultado.setText("Seu IMC é de: " + formato.format(resultado) + " e sua classificação é NORMAL");

        } else if (resultado > 25.0 && resultado < 29.9) {

            txtResultado.setText("Seu IMC é de: " + formato.format(resultado) + " e sua classificação é SOBREPESO");

        } else if (resultado > 30.0 && resultado < 39.9) {

            txtResultado.setText("Seu IMC é de: " + formato.format(resultado) + " e sua classificação é OBESIDADE");

        } else if (resultado > 40.0) {

            txtResultado.setText("Seu IMC é de: " + formato.format(resultado) + " e sua classificação é OBESIDADE GRAVE");

        } else if (resultado == 0 || resultado == 0.0) {

            Drawable drawable = getResources().getDrawable(R.drawable.info);
            imagem.setImageDrawable(drawable);

            txtResultado.setText("O cálculo do IMC é feito dividindo o peso (em quilogramas) pela" +
                    " altura (em metros) ao quadrado. De acordo com a tabela de IMC, você está no seu peso ideal");
        }

    }

}
