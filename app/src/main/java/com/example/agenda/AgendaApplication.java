package com.example.agenda;

import android.app.Application;

import com.example.agenda.dao.AlunoDAO;
import com.example.agenda.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunoTeste();
    }

    @SuppressWarnings("unused")
    private void criaAlunoTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salvar(new Aluno("Biassi", "11959659723", "thiagoh191000@gmail.com"));
        dao.salvar(new Aluno("Thiago", "11959659723", "thiagoh191000@gmail.com"));
    }
}
