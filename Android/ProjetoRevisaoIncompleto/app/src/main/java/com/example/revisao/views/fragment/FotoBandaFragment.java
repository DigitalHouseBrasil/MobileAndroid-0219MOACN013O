package com.example.revisao.views.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.revisao.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FotoBandaFragment extends Fragment {
    private TextView txtNomeBanda;
    private Button btnVoltar;

    public FotoBandaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Implementar a lógica de verificação dos dados recebidos e setar o nome da banda no textView
        //Implementar a lógica de ação do botão voltar

        return inflater.inflate(R.layout.fragment_foto_banda, container, false);

    }


}
