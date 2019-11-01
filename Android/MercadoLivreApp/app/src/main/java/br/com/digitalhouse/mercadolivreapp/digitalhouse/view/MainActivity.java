package br.com.digitalhouse.mercadolivreapp.digitalhouse.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.mercadolivreapp.digitalhouse.R;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.adapters.RecyclerViewMercadoLivreAdapter;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.model.Result;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.viewmodel.MercadoLivreViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SearchView editTextSearch;
    private RecyclerViewMercadoLivreAdapter adapter;
    private List<Result> results = new ArrayList<>();
    private MercadoLivreViewModel viewModel;
    private ProgressBar progressBar;
    //Declaração da variavel itemBusca com um valor já setado
    private String itemBusca = "Celular";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        /**Chama o método que pesquisa um item através do viewModel passando como parametro
         * um valor já pré configurado no header da classe
         */
        viewModel.searchItem(itemBusca);

        //Pega o valor da lista que está vindo do viewModel e seta no adapter
        viewModel.getResultLiveData().observe(this, results1 -> {
            adapter.update(results1);
        });

        viewModel.getLoading().observe(this, loading ->{
            if (loading){
                progressBar.setVisibility(View.VISIBLE);
            }else{
                progressBar.setVisibility(View.GONE);
            }
        });

        //Chamada do editTextSearch
        editTextSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            //Esse método é executado quando o usuario termina a digitação e faz um submit para realizar a consulta
            @Override
            public boolean onQueryTextSubmit(String query) {
                //está atribuindo o texto digitado pelo usuário para a variavel itemBusca
                itemBusca = query;
                //Chama o método clear do adapter para limpar a lista
                adapter.clear();
                //chama a pesquisa pela api passando como parametro o tem digitado pelo usuário
                viewModel.searchItem(itemBusca);
                return false;
            }

            //Esse método é executado quando o usuario está digitando uma palavra com mais de 3 caracteres
            @Override
            public boolean onQueryTextChange(String newText) {

                //Verifica se o texto tem mais que 3 caracteres
                if (newText.length() > 3){
                    //está atribuindo o texto digitado pelo usuário para a variavel itemBusca
                    itemBusca = newText;
                    //Chama o método clear do adapter para limpar a lista
                    adapter.clear();
                    //chama a pesquisa pela api passando como parametro o tem digitado pelo usuário
                    viewModel.searchItem(itemBusca);
                }
                return false;
            }
        });
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerview);
        editTextSearch = findViewById(R.id.edit_search);
        viewModel = ViewModelProviders.of(this).get(MercadoLivreViewModel.class);
        adapter = new RecyclerViewMercadoLivreAdapter(results);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        progressBar = findViewById(R.id.progress_bar);
    }
}
