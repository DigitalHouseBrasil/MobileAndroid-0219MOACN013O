package br.com.digitalhouse.appmytasks.views.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import br.com.digitalhouse.appmytasks.R;
import br.com.digitalhouse.appmytasks.model.pojos.Tarefa;
import br.com.digitalhouse.appmytasks.viewmodel.NovaTarefaViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class NovaTarefaFragment extends Fragment {
    private TextInputLayout nome;
    private TextInputLayout descricao;
    private FloatingActionButton btnAdd;
    //Declaração do ViewModel
    private NovaTarefaViewModel viewModel;

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

            if (!nomeTarefa.isEmpty() && !descricaoTarefa.isEmpty()) {

                Tarefa tarefa = new Tarefa(nomeTarefa, descricaoTarefa);

                //Método que insere a nova tarefa no banco de dados
                viewModel.insereTarefa(tarefa);

                nome.getEditText().setText("");
                descricao.getEditText().setText("");

                Snackbar.make(nome, "Dado salvo com sucesso!", Snackbar.LENGTH_LONG).show();

            } else {
                nome.setError("Preencha o campo de nome");
                descricao.setError("Preencha o campo de descrição");
            }

        });

        return view;
    }

    private void initViews(View view) {
        nome = view.findViewById(R.id.textInpuLayoutNome);
        descricao = view.findViewById(R.id.textInputLayoutDescricao);
        btnAdd = view.findViewById(R.id.floatingActionButtonSalvar);
        //Inicialização do ViewModel
        viewModel = ViewModelProviders.of(this).get(NovaTarefaViewModel.class);
    }


}
