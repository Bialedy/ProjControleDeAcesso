package com.Senai.controller;

import com.Senai.model.Professor;
import com.Senai.model.dao.json.ProfessorDAO;

import java.util.List;

public class ProfessorController {
    private ProfessorDAO professorDAO;

    public ProfessorController() {
        this.professorDAO = new ProfessorDAO();
    }
    public void adicionarProfesor(Professor professor) {
        professorDAO.inserirProfessor(professor);
    }

    public List<Professor> listarProfessores() {
        return professorDAO.listarProfessores();
    }

    public Professor buscarProfessorPorId(int id) {
        return professorDAO.buscarProfessorPorId(i));
    }

    public void atualizarAluno(Professor professor) {
        professorDAO.atualizarProfessor(professor);
    }

    public boolean removerProfessor(int id) {
        return professorDAO.removerProfessor(id);
    }
}
