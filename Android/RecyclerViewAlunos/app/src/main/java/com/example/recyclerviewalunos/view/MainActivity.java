package com.example.recyclerviewalunos.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import com.example.recyclerviewalunos.R;
import com.example.recyclerviewalunos.adapter.AdapterLista;
import com.example.recyclerviewalunos.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewAlunos;
    private AdapterLista adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewAlunos = findViewById(R.id.recycler_view);

        //Inicialização da classe adapter
        adapter = new AdapterLista(listaDeAlunos());

        //Setando o adapter para o componente recyclerView
        recyclerViewAlunos.setAdapter(adapter);

        //Definição do layout da lista utilizando a classe LayoutManager
        recyclerViewAlunos.setLayoutManager(new LinearLayoutManager(this));
    }

    //Método que retorna uma lista do tipo Contato
    private List<Aluno> listaDeAlunos(){
        List<Aluno> alunos = new ArrayList<>();


        alunos.add(new Aluno("Jessica", "FullStack"));
        alunos.add(new Aluno("João","Mobile Android"));
        alunos.add(new Aluno("Eduardo","UX/UI"));
        alunos.add(new Aluno("Alexandre", "IOS"));
        alunos.add(new Aluno("Denis", "Data"));
        alunos.add(new Aluno("Diego", "Marketing Digital"));
        alunos.add(new Aluno("Ariel", "Executivo"));
        alunos.add(new Aluno("Amanda", "DIP"));

        return alunos;
    }


}
