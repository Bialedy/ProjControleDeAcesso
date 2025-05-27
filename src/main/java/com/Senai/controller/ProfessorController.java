package com.Senai.controller;

import com.Senai.model.Professor;
import com.Senai.model.dao.json.ProfessorDAO;

import java.util.List;

public class ProfessorController {

    public ProfessorDAO professorDAO;

    public ProfessorController() {
        this.professorDAO = new ProfessorDAO();
    }
    public void cadastrarProfessor(Professor professor) {
        professorDAO.inserirProfessor(professor);
        return false;
    }

    public List<Professor> listarProfessores() {
        return professorDAO.listarProfessores();
    }


    public void atualizarProfessor(int id, String nome, int cpf, String endereco, int telefone, String email, String login, String senha) {
        professorDAO.atualizarProfessor(professor);
    }

    public boolean removerProfessor(int id) {

        return professorDAO.removerProfessor(id);
    }

    public void adicionarProfessor(Professor novoProfessor) {
    }
}
