package com.example.projetogatocachorro.views;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.projetogatocachorro.R;
import com.example.projetogatocachorro.interfaces.Comunicador;
import com.example.projetogatocachorro.model.Animal;


/**
 * A simple {@link Fragment} subclass.
 */
public class BotoesFragment extends Fragment {
    private Button btnGato;
    private Button btnCachorro;
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

    public BotoesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_botoes, container, false);

        initViews(view);

        btnGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animal gato = new Animal(R.drawable.gato, "Gato");
                comunicador.recebeAnimal(gato);
            }
        });

        btnCachorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animal cachorro = new Animal(R.drawable.cachorro, "Cachorro");
                comunicador.recebeAnimal(cachorro);
            }
        });



    return view;
    }

    private void initViews(View view){
        btnGato = view.findViewById(R.id.btnGato);
        btnCachorro = view.findViewById(R.id.btnCachorro);
    }

}
