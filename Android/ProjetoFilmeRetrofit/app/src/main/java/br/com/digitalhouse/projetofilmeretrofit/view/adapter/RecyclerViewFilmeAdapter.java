package br.com.digitalhouse.projetofilmeretrofit.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.digitalhouse.projetofilmeretrofit.R;
import br.com.digitalhouse.projetofilmeretrofit.model.Filme;
import br.com.digitalhouse.projetofilmeretrofit.view.interfaces.OnClick;

public class RecyclerViewFilmeAdapter extends RecyclerView.Adapter<RecyclerViewFilmeAdapter.ViewHolder> {

    private List<Filme> fimesList;
    private OnClick listener;

    public RecyclerViewFilmeAdapter(List<Filme> fimesList, OnClick listener) {
        this.fimesList = fimesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Filme filme = fimesList.get(position);
        holder.onBind(filme);

        holder.itemView.setOnClickListener(v -> listener.click(filme));
    }

    @Override
    public int getItemCount() {
        return fimesList.size();
    }

    //Método que atualiza a lista
    public void atualizaLista(List<Filme> novaLista){
        //Se a lista for vazia ele adiciona na lista vazia os valores da lista de dados que está chegando
       if (this.fimesList.isEmpty()){
           this.fimesList = novaLista;
       }else{
           //Se a lista não for vazia e já possuir dados nós adicionamos nessa lista os novos dados que estão chegando em sequencia
           //ou seja logo após o ultimo item da lista adicionamos os novos dados em sequencia como se fosse uma fila
           this.fimesList.addAll(novaLista);
       }
       //No final notificamos as mudanças acontecidas
       notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgFilme);
            textView = itemView.findViewById(R.id.txtTitulo);
        }

        public void onBind(Filme filme) {

            textView.setText(filme.getTitle());

            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+ filme.getPosterPath()).into(imageView);
        }
    }
}
