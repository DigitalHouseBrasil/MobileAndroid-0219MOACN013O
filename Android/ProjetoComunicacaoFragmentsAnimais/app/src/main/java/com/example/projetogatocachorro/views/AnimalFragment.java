package com.example.projetogatocachorro.views;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projetogatocachorro.R;
import com.example.projetogatocachorro.model.Animal;

import static com.example.projetogatocachorro.views.MainActivity.ANIMAL_KEY;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalFragment extends Fragment {
    private ImageView imagem;
    private TextView nomeAnimal;


    public AnimalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animal, container, false);

        initViews(view);

        if (!getArguments().isEmpty()) {
            Animal animal = getArguments().getParcelable(ANIMAL_KEY);

            if (animal != null) {

                Drawable drawable = getResources().getDrawable(animal.getImagem());

                imagem.setImageDrawable(drawable);
                nomeAnimal.setText(animal.getNome());

            }
        }

        return view;
    }

    private void initViews(View view) {
        imagem = view.findViewById(R.id.imageViewAnimal);
        nomeAnimal = view.findViewById(R.id.textViewAnimal);
    }
}
