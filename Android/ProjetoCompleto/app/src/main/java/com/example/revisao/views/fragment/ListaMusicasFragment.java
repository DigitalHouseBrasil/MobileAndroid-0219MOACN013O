package com.example.revisao.views.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.revisao.R;
import com.example.revisao.views.adapter.MusicasAdapter;
import com.example.revisao.views.interfaces.RecyclerViewOnClick;
import com.example.revisao.views.model.Musica;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaMusicasFragment extends Fragment implements RecyclerViewOnClick {
    private RecyclerView recyclerView;
    private MusicasAdapter adapter;
    private List<Musica> listaMusicas = new ArrayList<>();
    public static final String MUSICA_KEY_DETALHE = "musica_detalhe";

    public ListaMusicasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_musicas, container, false);

        recyclerView = view.findViewById(R.id.listaMusicasRecyclerView);
        adapter = new MusicasAdapter(retornaListaMuscias(), this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


    return view;
    }

    private List<Musica> retornaListaMuscias(){

        listaMusicas.add(new Musica("Pink", "Pink it's my new obsession\n" +
                "Yeah, pink it's not even a question\n" +
                "Pink on the lips of your lover, cause\n" +
                "Pink is the love you discovah\n" +
                "Pink as the bing on your cherry\n" +
                "Pink cause you are so very\n" +
                "Pink it's the color of passion\n" +
                "A-cause today it just goes with the fashion"));

        listaMusicas.add(new Musica("Crazy", "Pink it's my new obsession\n" +
                "Yeah, pink it's not even a question\n" +
                "Pink on the lips of your lover, cause\n" +
                "Pink is the love you discovah\n" +
                "Pink as the bing on your cherry\n" +
                "Pink cause you are so very\n" +
                "Pink it's the color of passion\n" +
                "A-cause today it just goes with the fashion"));

        listaMusicas.add(new Musica("Cryn", "Pink it's my new obsession\n" +
                "Yeah, pink it's not even a question\n" +
                "Pink on the lips of your lover, cause\n" +
                "Pink is the love you discovah\n" +
                "Pink as the bing on your cherry\n" +
                "Pink cause you are so very\n" +
                "Pink it's the color of passion\n" +
                "A-cause today it just goes with the fashion"));

        return listaMusicas;
    }

    @Override
    public void detalheMusica(Musica musica) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(MUSICA_KEY_DETALHE, musica);

        Fragment fragmentDetalhe = new MusicaDetalheFragment();
        fragmentDetalhe.setArguments(bundle);

        replaceFragment(fragmentDetalhe);
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

}
