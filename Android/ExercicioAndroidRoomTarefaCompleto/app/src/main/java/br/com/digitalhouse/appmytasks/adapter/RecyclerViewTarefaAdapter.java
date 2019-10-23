package br.com.digitalhouse.appmytasks.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import br.com.digitalhouse.appmytasks.R;
import br.com.digitalhouse.appmytasks.model.Tarefa;

public class RecyclerViewTarefaAdapter extends RecyclerView.Adapter<RecyclerViewTarefaAdapter.ViewHolder> {

    private List<Tarefa> tarefaList;

    public RecyclerViewTarefaAdapter(List<Tarefa> tarefaList) {
        this.tarefaList = tarefaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view_tarefas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tarefa tarefa = tarefaList.get(position);
        holder.onBind(tarefa);
    }

    @Override
    public int getItemCount() {
        return tarefaList.size();
    }

    public void atualizaLista(List<Tarefa> novaLista){
        this.tarefaList.clear();
        this.tarefaList = novaLista;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textViewNomeTarefa);
        }

        public void onBind(Tarefa tarefa) {
            nome.setText(tarefa.getNome());
        }
    }
}
