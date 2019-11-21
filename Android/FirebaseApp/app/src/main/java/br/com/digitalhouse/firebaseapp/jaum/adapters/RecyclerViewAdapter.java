package br.com.digitalhouse.firebaseapp.jaum.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.digitalhouse.firebaseapp.R;
import br.com.digitalhouse.firebaseapp.jaum.interfaces.FavoriteItemClick;
import br.com.digitalhouse.firebaseapp.jaum.interfaces.RecyclerViewClick;
import br.com.digitalhouse.firebaseapp.jaum.model.Result;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Result> results;
    private RecyclerViewClick listener;
    private FavoriteItemClick favoriteItemClick;

    public RecyclerViewAdapter(List<Result> results, RecyclerViewClick listener, FavoriteItemClick favoriteItemClick) {
        this.results = results;
        this.listener = listener;
        this.favoriteItemClick = favoriteItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Result result = results.get(i);
        viewHolder.bind(result);

        viewHolder.itemView.setOnClickListener(v -> listener.clickListener(result));
        viewHolder.imageFavorite.setOnClickListener(v -> favoriteItemClick.addFavoriteClickListener(result));
    }

    //método que atualiza a lista do adapter
    public void setResult(List<Result> results) {
        //verificar se o result já tem informação
        if (results.size() == 0) {
            this.results = results;
        } else {
            this.results.addAll(results);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFilme;
        private TextView txtTituloFilme;
        private ImageView imageFavorite;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFilme = itemView.findViewById(R.id.imgFilme);
            txtTituloFilme = itemView.findViewById(R.id.txtTitulo);
            imageFavorite = itemView.findViewById(R.id.imageFavorite);
        }

        public void bind(Result result) {
            txtTituloFilme.setText(result.getTitle());

            //Pegando a imagem de poster do filme através do Picasso
            Picasso.get().load("http://image.tmdb.org/t/p/w500/" + result.getPosterPath()).into(imgFilme);
        }
    }
}
