package br.com.digitalhouse.projetofilmeretrofit.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.projetofilmeretrofit.R;
import br.com.digitalhouse.projetofilmeretrofit.model.Filme;
import br.com.digitalhouse.projetofilmeretrofit.view.adapter.RecyclerViewFilmeAdapter;
import br.com.digitalhouse.projetofilmeretrofit.view.interfaces.OnClick;
import br.com.digitalhouse.projetofilmeretrofit.viewmodel.FilmeViewModel;

public class MainActivity extends AppCompatActivity implements OnClick {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private RecyclerViewFilmeAdapter adapter;
    private List<Filme> listaFilmes = new ArrayList<>();
    private FilmeViewModel viewModel;
    //Atributo para armazenar a o valor da pagina atual
    private int pagina = 1;
    public static final String API_KEY = "bde8033d3274c91b292a5293c6349052";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setScrollView();

        viewModel.getAllFilmes(API_KEY, pagina);

        viewModel.getListaFilme().observe(this, resultaLista -> {
            adapter.atualizaLista(resultaLista);
        });

        viewModel.getLoading().observe(this, loading -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerViewFilmes);
        progressBar = findViewById(R.id.progress_bar);
        adapter = new RecyclerViewFilmeAdapter(listaFilmes, this);
        viewModel = ViewModelProviders.of(this).get(FilmeViewModel.class);
    }

    @Override
    public void click(Filme filme) {
        Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("Filme", filme);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //Método que realiza a páginação noi scroll do recyclerView
    private void setScrollView() {

        //Adicionamos o listener no recyclerView e sobrescrevemos os métodos do listener do recyclerview
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            //Método que ouve o status de mudança do recyclerview
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            //Método que realmente aconte o scroll do recyclerview e aqui acontece a páginação
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                //Recuperamos o layout setado no  recyclerview em uma nova instancia do layout definido
                //Nesse caso estou trabalhando com o LinearLayoutManager
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                //variavel que irá receber o retorno da quantidade de itens no adapter vinculado ao RecyclerView
                int totalItemCount = layoutManager.getItemCount();

                //Variavel que irá receber a posição do adapter do último item visível.
                int lastVisible = layoutManager.findLastVisibleItemPosition();

                //Variavel que um verdadeiro ou falso caso o valor da posição do ultimo item + 5
                // seja maior ou igual que a quantidade de intens total na lista
                boolean ultimoItem = lastVisible + 5 >= totalItemCount;

                //Verificação se a quantidade total de itens na lista for maior que zero e se o valor da variavel ultimoItem é verdadeiro
                //Se a condição for verdadeira o atributo de pagina irá incrementar mais 1 e chamamos o viewmodel solicitando novos dados para a api
                if (totalItemCount > 0 && ultimoItem) {
                    pagina++;
                    viewModel.getAllFilmes(API_KEY, pagina);
                }
            }
        });

    }
}
