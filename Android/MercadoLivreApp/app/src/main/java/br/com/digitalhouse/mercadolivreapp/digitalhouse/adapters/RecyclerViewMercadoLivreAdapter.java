package br.com.digitalhouse.mercadolivreapp.digitalhouse.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.mercadolivreapp.digitalhouse.R;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.model.Result;


public class RecyclerViewMercadoLivreAdapter extends RecyclerView.Adapter<RecyclerViewMercadoLivreAdapter.ViewHolder> {

    private List<Result> results;

    public RecyclerViewMercadoLivreAdapter(List<Result> newsList) {
        this.results = newsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result results = this.results.get(position);
        holder.bind(results);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    //Método que atualiza a lista
    public void update(List<Result> results) {
        this.results.clear();
        this.results = results;
        notifyDataSetChanged();
    }

    //Metodo que limpa a lista
    public void clear() {
        this.results.clear();
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;
        private ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescripotion);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void bind(Result result) {
            textViewTitle.setText(result.getTitle());
            textViewDescription.setText(result.getAddress().getStateName());

            Picasso.get()
                    .load(result.getThumbnail()).into(imageView);

        }

    }
}

