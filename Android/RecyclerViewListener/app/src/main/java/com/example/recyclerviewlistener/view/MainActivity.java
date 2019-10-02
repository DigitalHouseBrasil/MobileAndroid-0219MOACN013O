package com.example.recyclerviewlistener.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.recyclerviewlistener.R;
import com.example.recyclerviewlistener.adapter.AnimalAdapter;
import com.example.recyclerviewlistener.interfaces.RecyclerViewOnClick;
import com.example.recyclerviewlistener.modelo.Animal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewOnClick {
    private RecyclerView recyclerView;
    private AnimalAdapter adapter;
    private List<Animal> animalList = new ArrayList<>();
    public static final String ANIMAL_KEY = "animal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewAnimais);

        //Passamos o valor para o construtor da classe adapter
        adapter = new AnimalAdapter(getAnimais(), this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private List<Animal> getAnimais() {

        animalList.add(new Animal(R.drawable.cachorro, "Cachorro", "Esse é um animal chamado cachorro"));
        animalList.add(new Animal(R.drawable.gato, "Gato", "Esse é um animal chamado gato"));
        animalList.add(new Animal(R.drawable.leao, "Leao", "Esse é um animal chamado leão"));

        return animalList;
    }

    //Sobrescrita do método a partir da implementação da interface de click
    @Override
    public void onClick(Animal animal) {
        //Envio do objeto para a tela de detalhe
        Intent intent = new Intent(MainActivity.this, DetalheAnimalActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ANIMAL_KEY, animal);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
