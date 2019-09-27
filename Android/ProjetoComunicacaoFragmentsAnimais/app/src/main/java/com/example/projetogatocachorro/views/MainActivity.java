package com.example.projetogatocachorro.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.projetogatocachorro.R;
import com.example.projetogatocachorro.interfaces.Comunicador;
import com.example.projetogatocachorro.model.Animal;

public class MainActivity extends AppCompatActivity implements Comunicador {
    public static final String ANIMAL_KEY = "animal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(R.id.container2, new BotoesFragment());
    }

    @Override
    public void recebeAnimal(Animal animal) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ANIMAL_KEY, animal);

        Fragment animalFragment = new AnimalFragment();
        animalFragment.setArguments(bundle);

        replaceFragment(R.id.container1, animalFragment);
    }

    private void replaceFragment(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }
}
