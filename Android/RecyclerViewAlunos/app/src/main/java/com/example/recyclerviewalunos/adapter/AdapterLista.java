package com.example.recyclerviewalunos.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerviewalunos.R;
import com.example.recyclerviewalunos.model.Aluno;

import java.util.List;

public class AdapterLista extends RecyclerView.Adapter<AdapterLista.ViewHolderAluno> {

    private List<Aluno> alunos;


    public AdapterLista(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @NonNull
    @Override
    public ViewHolderAluno onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        return new ViewHolderAluno(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAluno viewHolderAluno, int i) {

        Aluno aluno = alunos.get(i);

        viewHolderAluno.bind(aluno);

    }

    @Override
    public int getItemCount() {
        return alunos.size();
    }

    class ViewHolderAluno extends RecyclerView.ViewHolder{
        TextView textName;
        TextView textCurso;


        public ViewHolderAluno(@NonNull View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.text_name);
            textCurso = itemView.findViewById(R.id.text_curso);
        }

        public void bind(Aluno aluno){
            textCurso.setText(aluno.getCurso());
            textName.setText(aluno.getNome());
        }
    }
}
