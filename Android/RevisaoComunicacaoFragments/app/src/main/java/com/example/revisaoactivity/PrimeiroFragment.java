package com.example.revisaoactivity;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrimeiroFragment extends Fragment {
    private Button btmEnviar;
    private Comunicador comunicador;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            comunicador = (Comunicador) context;
        }catch (Exception ex){
            ex.getStackTrace();
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

       btmEnviar = view.findViewById(R.id.btnEnviar);

       btmEnviar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               comunicador.receberMensagem("Comunicação entre Fragments! Melhor aula =)");
           }
       });

    return view;
    }

}
