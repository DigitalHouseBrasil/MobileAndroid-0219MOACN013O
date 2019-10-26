package br.com.digitalhouse.json.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.json.R;
import br.com.digitalhouse.json.model.Noticia;

public class NoticiasRecyclerViewAdapter extends RecyclerView.Adapter<NoticiasRecyclerViewAdapter.ViewHolder> {
    private List<Noticia> listaNoticias;

    public NoticiasRecyclerViewAdapter(List<Noticia> listaNoticias) {
        this.listaNoticias = listaNoticias;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_noticias, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Noticia noticia = listaNoticias.get(position);
        holder.onBind(noticia);
    }

    @Override
    public int getItemCount() {
        return listaNoticias.size();
    }


    public void update(List<Noticia> noticiasList) {
        this.listaNoticias.clear();
        this.listaNoticias = noticiasList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewTitulo;
        private TextView textViewDescricao;
        private TextView textViewData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitulo = itemView.findViewById(R.id.textViewTitle);
            textViewDescricao = itemView.findViewById(R.id.textViewDescricao);
            textViewData = itemView.findViewById(R.id.textViewData);
        }

        public void onBind(Noticia noticia) {
            textViewTitulo.setText(noticia.getTitle());
            textViewDescricao.setText(noticia.getDescription());
            textViewData.setText(noticia.getDate());
        }
    }
}
