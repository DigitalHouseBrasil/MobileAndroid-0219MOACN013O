package br.com.digitalhouse.projetofilmeretrofit.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.projetofilmeretrofit.R;
import br.com.digitalhouse.projetofilmeretrofit.model.Filme;
import br.com.digitalhouse.projetofilmeretrofit.view.adapter.RecyclerViewFilmeAdapter;
import br.com.digitalhouse.projetofilmeretrofit.viewmodel.FilmeViewModel;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private RecyclerViewFilmeAdapter adapter;
    private List<Filme> listaFilmes = new ArrayList<>();
    private FilmeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        //TODO: Para resolver a exceção que estava sendo causada basta alterar o nome da classe Filme para  Filme

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getAllFilmes("bde8033d3274c91b292a5293c6349052");

        viewModel.getListaFilme().observe(this, resultaLista -> {
            adapter.atualizaLista(resultaLista);
        });

        viewModel.getLoading().observe(this, loading -> {
            if (loading){
                progressBar.setVisibility(View.VISIBLE);
            }else{
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void initViews(){
        recyclerView = findViewById(R.id.recyclerViewFilmes);
        progressBar = findViewById(R.id.progress_bar);
        adapter = new RecyclerViewFilmeAdapter(listaFilmes);
        viewModel = ViewModelProviders.of(this).get(FilmeViewModel.class);
    }
}
