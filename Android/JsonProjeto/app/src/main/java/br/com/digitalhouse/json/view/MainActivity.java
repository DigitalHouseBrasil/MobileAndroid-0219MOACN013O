package br.com.digitalhouse.json.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.json.R;
import br.com.digitalhouse.json.model.Noticia;
import br.com.digitalhouse.json.view.adapter.NoticiasRecyclerViewAdapter;
import br.com.digitalhouse.json.viewmodel.NoticiaViewModel;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private NoticiaViewModel viewModel;
    private List<Noticia> noticias = new ArrayList<>();
    private NoticiasRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.buscaNoticias();

        viewModel.retornaNoticas().observe(this, noticiasRetornada ->{
            adapter.update(noticiasRetornada);
        });

        viewModel.retornaValorLoading().observe(this, loading ->{
            if(loading){
                progressBar.setVisibility(View.VISIBLE);
            }else{
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void initViews(){
        recyclerView = findViewById(R.id.recyclerViewNoticias);
        progressBar = findViewById(R.id.progressBar);
        adapter = new NoticiasRecyclerViewAdapter(noticias);
        viewModel = ViewModelProviders.of(this).get(NoticiaViewModel.class);
    }
}
