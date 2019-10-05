package com.example.revisao.views.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.revisao.R;
import com.example.revisao.views.model.Musica;

import static com.example.revisao.views.fragment.ListaMusicasFragment.MUSICA_KEY_DETALHE;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicaDetalheFragment extends Fragment {
    private TextView txtNomeDetalhe;
    private TextView txtMusicaDetalhe;


    public MusicaDetalheFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_musica_detalhe, container, false);

        initViews(view);

        if (getArguments() != null) {

            Musica musica = getArguments().getParcelable(MUSICA_KEY_DETALHE);

            txtNomeDetalhe.setText(musica.getNome());
            txtMusicaDetalhe.setText(musica.getLetraMusica());

        }

        return view;
    }

    private void initViews(View view) {
        txtNomeDetalhe = view.findViewById(R.id.textViewNomeMusicaDetalhe);
        txtMusicaDetalhe = view.findViewById(R.id.textViewLetraDaMusica);

    }

}
