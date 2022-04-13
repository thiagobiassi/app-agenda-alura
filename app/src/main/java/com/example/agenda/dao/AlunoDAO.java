package com.example.agenda.dao;

import com.example.agenda.model.Aluno;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salvar(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        atualizaIds();
    }

    private void atualizaIds() {
        contadorDeIds++;
    }

    public void edita(Aluno aluno){
        Aluno alunoEncontrado = buscaAlunoPorId(aluno);
        if (alunoEncontrado != null){
            int posicaoDoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoDoAluno, aluno);
        }
    }

    @Nullable
    private Aluno buscaAlunoPorId(Aluno aluno) {
        for (Aluno a: alunos) {
            if (a.getId() == aluno.getId()){
                return a;
            }
        }
        return null;
    }

    public List<Aluno> getAlunos(){
        return new ArrayList<>(alunos);
    }

    public void remove(Aluno aluno) {
        Aluno alunoDevolvido = buscaAlunoPorId(aluno);
        if (alunoDevolvido != null){
            alunos.remove(alunoDevolvido);
        }

    }
}
