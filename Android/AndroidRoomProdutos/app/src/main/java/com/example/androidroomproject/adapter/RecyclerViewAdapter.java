package com.example.androidroomproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidroomproject.R;
import com.example.androidroomproject.interfaces.OnClick;
import com.example.androidroomproject.model.Produto;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Produto> produtoList;
    private OnClick listener;

    public RecyclerViewAdapter(List<Produto> produtoList, OnClick listener) {
        this.produtoList = produtoList;
        this.listener = listener;
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

        holder.itemView.setOnClickListener(v -> {
            listener.onClick(produto);
        });

    }

    @Override
    public int getItemCount() {
        return produtoList.size();
    }

    //Método que atualiza a lista de produtos
    public void atualizaListaProduto(List<Produto> listaProdutos){
        this.produtoList.clear();
        this.produtoList = listaProdutos;
        notifyDataSetChanged();
    }

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
