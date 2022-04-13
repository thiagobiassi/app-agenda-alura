package com.example.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.agenda.R;
import com.example.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunosAdapter extends BaseAdapter {

    private final List<Aluno> alunos = new ArrayList<>();
    private final Context context;

    public ListaAlunosAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int posicao) {
        return alunos.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return alunos.get(posicao).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View viewCriada = criaView(convertView, viewGroup);
        Aluno alunoDevolvido = alunos.get(position);
        vincula(viewCriada, alunoDevolvido);
        return viewCriada;
    }

    private void vincula(View viewCriada, Aluno alunoDevolvido) {
        TextView nomeAluno = viewCriada.findViewById(R.id.item_aluno_nome);
        TextView telefoneAluno = viewCriada.findViewById(R.id.item_aluno_telefone);
        nomeAluno.setText(alunoDevolvido.getNome());
        telefoneAluno.setText(alunoDevolvido.getTelefone());
    }

    private View criaView(View convertView, ViewGroup viewGroup) {

        View view;

        if (convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_aluno, viewGroup, false);
        }else {
            view = convertView;
        }

        return view;
    }

    public void atualiza(List<Aluno> alunos){
        this.alunos.clear();
        this.alunos.addAll(alunos);
        notifyDataSetChanged();
    }

    public void remove(Aluno alunoEscolhido) {
        alunos.remove(alunoEscolhido);
        notifyDataSetChanged();
    }
}
