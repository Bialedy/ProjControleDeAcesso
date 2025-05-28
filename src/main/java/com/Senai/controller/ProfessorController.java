package com.Senai.controller;

import com.Senai.model.Professor;
import com.Senai.model.dao.json.ProfessorDAO;

import java.util.List;

public class ProfessorController {

    private ProfessorDAO professorDAO;

    public ProfessorController() {
        this.professorDAO = new ProfessorDAO();
    }

    public boolean cadastrarProfessor(Professor professor) {
        professorDAO.inserirProfessor(professor);
        return false;
    }

    public List<Professor> listarProfessores() {
        return professorDAO.listarProfessores();
    }

    public boolean atualizarProfessor(int id, String nome,int cpf, String endereco, int telefone, String email, String login, String senha, String disciplina) {
        Professor professor = new Professor(id, nome, cpf, endereco, telefone, email, login, senha, disciplina);
        return professorDAO.atualizarProfessor(professor);
    }

    public boolean removerProfessor(int id) {
        return professorDAO.removerProfessor(id);
    }

    public void adicionarProfessor(Professor novoProfessor) {
        professorDAO.inserirProfessor(novoProfessor);
    }
}

