package com.example.revisao.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.revisao.R;
import com.example.revisao.views.interfaces.RecyclerViewOnClick;
import com.example.revisao.views.model.Musica;

import java.util.List;

public class MusicasAdapter extends RecyclerView.Adapter<MusicasAdapter.ViewHolder> {

    private List<Musica> listaMusicas;
    private RecyclerViewOnClick listener;

    public MusicasAdapter(List<Musica> listaMusicas, RecyclerViewOnClick listener) {
        this.listaMusicas = listaMusicas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_musicas_recyclerview, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Musica musica = listaMusicas.get(position);
        holder.onBind(musica);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.detalheMusica(musica);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaMusicas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNomeMusica;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNomeMusica = itemView.findViewById(R.id.textViewNomeMusica);
        }

        public void onBind(Musica musica){
            txtNomeMusica.setText(musica.getNome());
        }
    }
}
