package com.example.agenda;

import android.app.Application;

import com.example.agenda.dao.AlunoDAO;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunoTeste();
    }

    @SuppressWarnings("unused")
    private void criaAlunoTeste() {
        AlunoDAO dao = new AlunoDAO();
    }
}
