package com.example.revisao.views.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.revisao.R;
import com.example.revisao.views.interfaces.Comunicador;

/**
 * A simple {@link Fragment} subclass.
 */
public class BandaFragment extends Fragment {
    private Button btnVerFoto;
    private Comunicador comunicador;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            comunicador = (Comunicador) context;
        }catch (Exception ex){
            ex.getStackTrace();
        }
    }

    public BandaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_banda, container, false);

        btnVerFoto = view.findViewById(R.id.btnVerFoto);

        btnVerFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comunicador.recebeNomeDaBanda("Aerosmith <3");
            }
        });

        return view;
    }

}
