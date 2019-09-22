package com.example.revisaoactivity;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.revisaoactivity.MainActivity.MSG_KEY;


/**
 * A simple {@link Fragment} subclass.
 */
public class SegundoFragment extends Fragment {
    private TextView mensagem;

    public SegundoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_segundo, container, false);

        mensagem = view.findViewById(R.id.textNome);

        if (!getArguments().isEmpty()) {

           String mensagemRecebida = getArguments().getString(MSG_KEY);

           mensagem.setText(mensagemRecebida);
        }


        return view;
    }

}
