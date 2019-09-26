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

/**
 * A simple {@link Fragment} subclass.
 */
public class BandaFragment extends Fragment {
    private Button btnVerFoto;

    //Sobreescever o método onAttach e implementar a lógica de inicialização do atributo do tipo Comunicador

    public BandaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Invocar o método da interface através do atributo comunicador
        //Implementar a lógica de ação do botão ver foto

        return inflater.inflate(R.layout.fragment_banda, container, false);


    }

}
