package com.example.recyclerviewlistener.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewlistener.R;
import com.example.recyclerviewlistener.interfaces.RecyclerViewOnClick;
import com.example.recyclerviewlistener.modelo.Animal;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {

    private List<Animal> animalList;

    //Atributo do tipo da Interface criada para comunicar o click
    private RecyclerViewOnClick listener;

    //Adicionamos um novo parametro no contrutor da classe do tipo da interface
    public AnimalAdapter(List<Animal> animalList, RecyclerViewOnClick listener) {
        this.animalList = animalList;
        //Inicializamos o atributo do tipo da interface
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_animal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Animal animal = animalList.get(position);
        holder.onBind(animal);

        //Seta a função de click no itemView(que é um parametro passado no construtor da classe
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chamada do método da interface através do atributo
                listener.onClick(animal);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView txtNome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            txtNome = itemView.findViewById(R.id.textViewNome);
        }

        public void onBind(Animal animal){

            Drawable drawable = itemView.getResources().getDrawable(animal.getImagem());
            imageView.setImageDrawable(drawable);
            txtNome.setText(animal.getNome());
        }
    }
}
