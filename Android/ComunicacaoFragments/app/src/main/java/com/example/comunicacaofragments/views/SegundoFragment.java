package com.example.comunicacaofragments.views;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.comunicacaofragments.R;
import com.example.comunicacaofragments.model.SistemaOperacional;

import static com.example.comunicacaofragments.views.MainActivity.SO_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class SegundoFragment extends Fragment {
    private ImageView imagem;
    private TextView txtNome;

    public SegundoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_segundo, container, false);

        //Método que inicializa a view
        initView(view);

        //Condição que verifica se o getArguments não está vindo nulo
        if (!getArguments().isEmpty()){

            //Adicionando as informações vindas para um novo objeto
            SistemaOperacional sistemaOperacional = getArguments().getParcelable(SO_KEY);

            //Verifica se o objeto não é nulo
            if (sistemaOperacional != null){

                //Nova instancia de um objeto drawable
                Drawable drawable = getResources().getDrawable(sistemaOperacional.getImagem());

                //Setando a imagem para o componente imageView
                imagem.setImageDrawable(drawable);

                //Setando um texto para um componente TextView
                txtNome.setText(sistemaOperacional.getNome());
            }
        }

        //Retorna a View
        return view;
    }

    //Método que inicializa as views
    private void initView(View view){
        imagem = view.findViewById(R.id.image);
        txtNome = view.findViewById(R.id.textAndroid);
    }

}
