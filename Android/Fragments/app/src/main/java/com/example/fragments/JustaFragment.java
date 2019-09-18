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
public class JustaFragment extends Fragment {
    private Button btnCuriosidade;

    public JustaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_justa, container, false);

        btnCuriosidade = view.findViewById(R.id.buttonCuriosidadeJusta);

        btnCuriosidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "A Praia da Justa está localizada aproximadamente a 28 Km do centro de Ubatuba",
                        Snackbar.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
