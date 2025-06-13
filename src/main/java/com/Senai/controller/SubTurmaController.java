package com.Senai.controller;

import com.Senai.model.SubTurma;
import com.Senai.model.json.dao.SubTurmaDAO;
import java.util.List;

public class SubTurmaController {
    private SubTurmaDAO subturmaDAO;

    public SubTurmaController() {
        this.subturmaDAO = new SubTurmaDAO();
    }

    public void adicionarSubTurma(SubTurma subturma) {
        subturmaDAO.inserirSubTurma(subturma);
    }

    public List<SubTurma> listarSubTurma() {
        return subturmaDAO.listarSubTurmas();
    }

    public SubTurma buscarSubTurmaPorId(int id) {
        return subturmaDAO.buscarSubTurmaPorId(id);
    }

    public void atualizarSubTurma(SubTurma subturma) {
        subturmaDAO.atualizarSubTurma(subturma);
    }

    public boolean removerSubTurma(int id) {
        return subturmaDAO.removerSubTurma(id);
    }
}
