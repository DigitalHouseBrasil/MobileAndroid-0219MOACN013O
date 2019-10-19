package com.example.androidroomproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidroomproject.R;
import com.example.androidroomproject.model.Produto;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Produto> produtoList;
    //Implementar o listener

    public RecyclerViewAdapter(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produtos_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Produto produto = produtoList.get(position);
        holder.onBind(produto);
    }

    @Override
    public int getItemCount() {
        return produtoList.size();
    }

    //Implementar o método que atualiza a lista

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nome;
        private TextView preco;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textViewNome);
            preco = itemView.findViewById(R.id.textViewPreco);
        }

        public void onBind(Produto produto) {

            nome.setText(produto.getNomeProduto());
            String precoString = String.valueOf(produto.getPreco());
            preco.setText(precoString);
        }
    }
}
