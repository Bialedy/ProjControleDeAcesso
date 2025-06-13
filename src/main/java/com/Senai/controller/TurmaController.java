package com.Senai.controller;

import com.Senai.model.Turma;
import com.Senai.model.json.dao.TurmaDAO;
import java.util.List;

public class TurmaController {
    private TurmaDAO turmaDAO;

    public TurmaController() {
        this.turmaDAO = new TurmaDAO();
    }

    public void adicionarTurma(Turma turma) {
        turmaDAO.inserirTurma(turma);
    }

    public List<Turma> listarTurma() {
        return turmaDAO.listarTurmas();
    }

    public Turma buscarTurmaPorId(int id) {
        return turmaDAO.buscarTurmaPorId(id);
    }

    public void atualizarTurma(Turma turma) {
        turmaDAO.atualizarTurma(turma);
    }

    public boolean removerTurma(int id) {
        return turmaDAO.removerTurma(id);
    }
}
