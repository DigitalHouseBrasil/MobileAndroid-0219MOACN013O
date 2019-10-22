package br.com.digitalhouse.appmytasks.views.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import br.com.digitalhouse.appmytasks.R;
import br.com.digitalhouse.appmytasks.data.Database;
import br.com.digitalhouse.appmytasks.data.TarefaDao;
import br.com.digitalhouse.appmytasks.model.Tarefa;

/**
 * A simple {@link Fragment} subclass.
 */
public class NovaTarefaFragment extends Fragment {
    private TextInputLayout nome;
    private TextInputLayout descricao;
    private FloatingActionButton btnAdd;

    public NovaTarefaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nova_tarefa, container, false);

        initViews(view);

        btnAdd.setOnClickListener(v -> {
            String nomeTarefa = nome.getEditText().getText().toString();
            String descricaoTarefa = descricao.getEditText().getText().toString();


            //TODO: Desenvolver a ação de inserção dos dados no BD

        });

        return view;
    }

    private void initViews(View view) {
        nome = view.findViewById(R.id.textInpuLayoutNome);
        descricao = view.findViewById(R.id.textInputLayoutDescricao);
        btnAdd = view.findViewById(R.id.floatingActionButtonSalvar);

        //TODO: inicializar o DAO
    }


}
