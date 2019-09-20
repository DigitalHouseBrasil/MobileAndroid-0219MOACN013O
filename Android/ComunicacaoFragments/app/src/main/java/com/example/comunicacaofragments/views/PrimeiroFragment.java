package com.example.comunicacaofragments.views;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.comunicacaofragments.R;
import com.example.comunicacaofragments.interfaces.Comunicador;
import com.example.comunicacaofragments.model.SistemaOperacional;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrimeiroFragment extends Fragment {
    //Declaração dos atributos
    private Comunicador comunicador;
    private Button btnAndroid;
    private Button btnIOs;

    public PrimeiroFragment() {
        // Required empty public constructor
    }

    //Sobreescrita do método onAttach e inicialização do atributo comunicador
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            comunicador = (Comunicador) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primeiro, container, false);

        //Chamada do método que inicializa as views
        initViews(view);

        //Ação de clique no botão referente ao Android
        btnAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Criando um objeto
                SistemaOperacional android = new SistemaOperacional(R.drawable.cupcake,
                        "Android Cupcake 1.5 lançado em 2000");

                //passagem do parametro do objeto android
                comunicador.recebeMensagem(android);
            }
        });

        btnIOs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Criando um objeto
                SistemaOperacional ios= new SistemaOperacional(R.drawable.apple,
                        "IOS 7 lançado publicamente dia 18/09/2013");

                //passagem do parametro do objeto android
                comunicador.recebeMensagem(ios);
            }
        });

        //Retorno da view
        return view;
    }

    //Método que inicializa a view
    public void initViews(View view){
        btnAndroid = view.findViewById(R.id.btnAndroid);
        btnIOs = view.findViewById(R.id.btnIos);
    }
}
