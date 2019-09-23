package com.example.carrosfamosos.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.carrosfamosos.R;
import com.example.carrosfamosos.interfaces.Comunicador;
import com.example.carrosfamosos.model.Carro;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBotao extends Fragment {
    private Button btnCamaro;
    private Button btnFusca;
    private Comunicador comunicador;


    public FragmentBotao() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            comunicador = (Comunicador) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_botao, container, false);
        initView(view);

        btnFusca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Carro fusca = new Carro(R.drawable.fusca, "FUSCA LINDO");
                comunicador.recebeMensagem(fusca);
            }
        });


        btnCamaro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Carro camaro = new Carro(R.drawable.camaro, "CAMARO FODA");
                comunicador.recebeMensagem(camaro);
            }
        });

        return view;
    }

    public void initView(View view){
        btnCamaro = view.findViewById(R.id.btn_camaro);
        btnFusca = view.findViewById(R.id.btn_fusca);
    }

}
