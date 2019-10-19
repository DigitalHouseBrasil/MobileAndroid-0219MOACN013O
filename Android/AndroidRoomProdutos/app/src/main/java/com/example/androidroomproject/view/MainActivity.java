package com.example.androidroomproject.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidroomproject.R;
import com.example.androidroomproject.adapter.RecyclerViewAdapter;
import com.example.androidroomproject.data.Database;
import com.example.androidroomproject.data.ProdutoDao;
import com.example.androidroomproject.interfaces.OnClick;
import com.example.androidroomproject.model.Produto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements OnClick {
    private FloatingActionButton btnAdd;
    private FloatingActionButton btnDelete;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<Produto> listaProdutos = new ArrayList<>();
    private TextInputLayout inputNomeProduto;
    private TextInputLayout inputPrecoProduto;
    private ProdutoDao produtoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnAdd.setOnClickListener(v -> {
            String nome = inputNomeProduto.getEditText().getText().toString();
            double preco = Double.parseDouble(inputPrecoProduto.getEditText().getText().toString());

            //Abre uma nova thread para que a ação de insert seja executado em paralelo
            new Thread(() -> {

                Produto produto = new Produto(nome, preco);

                if (produto != null) {

                    //Insere o produto no bd
                    produtoDao.insereProduto(produto);

                    //Traz todos os dados do bd
                    buscaTodosProdutos();
                }

            }).start();

            //Traz todos os dados do bd
            buscaTodosProdutos();

        });

        btnDelete.setOnClickListener(v -> {
            String nome = inputNomeProduto.getEditText().getText().toString();

            //Abre uma nova thread para que a ação de insert seja executado em paralelo
            new Thread(() -> {

                Produto produto = produtoDao.getByNome(nome);

                if (produto != null) {
                    //Apaga  o produto no bd
                    produtoDao.deleteProduto(produto);
                } else {
                    Log.i("TAG", "Delete produto de ruim");
                }

            }).start();

            inputNomeProduto.getEditText().setText("");
            inputPrecoProduto.getEditText().setText("");

        });

    }

    private void initViews() {
        btnAdd = findViewById(R.id.floatingActionButtonAdd);
        btnDelete = findViewById(R.id.floatingActionButtonDelete);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new RecyclerViewAdapter(listaProdutos, this);
        inputNomeProduto = findViewById(R.id.textInputLayoutNome);
        inputPrecoProduto = findViewById(R.id.textInputLayoutPreco);

        //Inicialização do DAO a partir da classe Database
        produtoDao = Database.getDatabase(this).produtoDao();
    }

    @Override
    public void onClick(Produto produto) {

        inputNomeProduto.getEditText().setText(produto.getNomeProduto());
        String preco = String.valueOf(produto.getPreco());
        inputPrecoProduto.getEditText().setText(preco);


    }

    private void buscaTodosProdutos() {

        //Chama o método que retorna os dados no bd , lembrando que esse método retorna um Observable
        produtoDao.getAllProdutos()
                //SubscribeOn: determina em qual thread o observable irá emitir os dados
                .subscribeOn(Schedulers.io())
                //ObserveOn: determina em qual thread será executa quando os dados forem emitidos
                .observeOn(AndroidSchedulers.mainThread())
                //Assina o observer ao observable
                //Se for sucesso irá pegar a lista de produtos e setar no método do adapter que atualiza a lista de produtos
                .subscribe(produtos -> {
                            adapter.atualizaListaProduto(produtos);
                        },

                        //Senão irá lançar uma exceção
                        throwable -> {
                            Log.i("TAG", "método getAllProdutos" + throwable.getMessage());
                        });
    }

}
