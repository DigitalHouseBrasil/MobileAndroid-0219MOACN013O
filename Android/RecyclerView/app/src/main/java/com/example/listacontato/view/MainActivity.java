package com.example.listacontato.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.example.listacontato.R;
import com.example.listacontato.adapter.ContatoAdapter;
import com.example.listacontato.model.Contatos;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ContatoAdapter adapter;
    private List<Contatos> listaContatos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.listaContatosRecyclerView);

        //Inicialização da classe Adapter
        adapter = new ContatoAdapter(retornarListaContatos());

        //Setando a adapter no componente do recyclerView
        recyclerView.setAdapter(adapter);

        //Setando o tipo de layout da lista (nesse exemplo será uma lista verticar)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    //Método que retorna uma lista de contatos
    public List<Contatos> retornarListaContatos(){

        listaContatos.add(new Contatos("Jessica", "0000000000"));
        listaContatos.add(new Contatos("Joao", "22222222222"));
        listaContatos.add(new Contatos("Ariel", "22222222222"));
        listaContatos.add(new Contatos("Rafael", "22222222222"));
        listaContatos.add(new Contatos("Andreza", "22222222222"));
        listaContatos.add(new Contatos("Robson", "22222222222"));
        listaContatos.add(new Contatos("William", "22222222222"));
        listaContatos.add(new Contatos("Victor", "22222222222"));
        listaContatos.add(new Contatos("Nina", "22222222222"));
        listaContatos.add(new Contatos("Deivid", "22222222222"));
        listaContatos.add(new Contatos("Luiz", "22222222222"));
        listaContatos.add(new Contatos("Josemar", "22222222222"));
        listaContatos.add(new Contatos("Cecilia", "22222222222"));
        listaContatos.add(new Contatos("Katheryne", "22222222222"));
        listaContatos.add(new Contatos("Camila", "22222222222"));

        return listaContatos;
    }

}
