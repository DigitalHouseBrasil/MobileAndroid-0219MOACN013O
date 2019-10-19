package com.example.androidroomproject.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidroomproject.R;
import com.example.androidroomproject.adapter.RecyclerViewAdapter;
import com.example.androidroomproject.model.Produto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton btnAdd;
    private FloatingActionButton btnDelete;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<Produto> listaProdutos = new ArrayList<>();
    private TextInputLayout inputNomeProduto;
    private TextInputLayout inputPrecoProduto;

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

            //Implementar o inser no BD

            //Listar os dados salvos no bd
        });

        btnDelete.setOnClickListener(v -> {
            String nome = inputNomeProduto.getEditText().getText().toString();

            //Implementar o delete do BD

            inputNomeProduto.getEditText().setText("");
            inputPrecoProduto.getEditText().setText("");

        });

    }

    private void initViews() {
        btnAdd = findViewById(R.id.floatingActionButtonAdd);
        btnDelete = findViewById(R.id.floatingActionButtonDelete);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new RecyclerViewAdapter(listaProdutos);
        inputNomeProduto = findViewById(R.id.textInputLayoutNome);
        inputPrecoProduto = findViewById(R.id.textInputLayoutPreco);
    }

    //Implementar o método de pesquisa dos dados

}
