package com.example.revisao.views.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.revisao.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaMusicasFragment extends Fragment {
    //Declarar os atributos componentes e o adapter

    public ListaMusicasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Implementar a lógica de setar o adapter e o LayoutManager para o componente do recyclerView

        //Criar a classe modelo

        //Criar a classe adapter e viewHolder e realizar toda a implementação lógica dos métodos

        return inflater.inflate(R.layout.fragment_lista_musicas, container, false);
    }

}
