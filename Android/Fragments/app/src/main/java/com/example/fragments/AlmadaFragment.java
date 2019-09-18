package com.example.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlmadaFragment extends Fragment {

    //criação do atributo do tipo Button
    private Button btnCuriosidade;

    public AlmadaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Criação da variavél view que recebe o método que infla o layout
        View view = inflater.inflate(R.layout.fragment_almada, container, false);

        //Chamada do método findViewById a partir da view
        btnCuriosidade = view.findViewById(R.id.buttonCuriosidadeAlmada);

        btnCuriosidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "O acesso à Comunidade da Almada se",Snackbar.LENGTH_LONG).show();
            }
        });

        //Retorno da view
        return view;
    }

}
