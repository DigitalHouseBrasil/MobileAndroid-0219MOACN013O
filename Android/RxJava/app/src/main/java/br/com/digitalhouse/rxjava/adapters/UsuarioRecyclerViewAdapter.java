package br.com.digitalhouse.rxjava.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.rxjava.R;
import br.com.digitalhouse.rxjava.model.Usuario;

public class UsuarioRecyclerViewAdapter extends RecyclerView.Adapter<UsuarioRecyclerViewAdapter.ViewHolder> {

    private List<Usuario> usuarios;

    public UsuarioRecyclerViewAdapter(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Usuario usuario = usuarios.get(position);
        holder.bind(usuario);
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public void update(List<Usuario> list) {
        this.usuarios = list;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewNome;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNome = itemView.findViewById(R.id.textViewNome);
        }

        private void bind(Usuario usuario) {
            textViewNome.setText(usuario.getNome());
        }
    }
}
