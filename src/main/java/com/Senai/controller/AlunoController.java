package com.Senai.controller;
import com.Senai.model.Aluno;
import com.Senai.model.dao.json.AlunoDAO;

import java.util.List;

public class AlunoController {

        private AlunoDAO alunoDAO;

        public AlunoController() {
            this.alunoDAO = new AlunoDAO();
        }

        public void adicionarAluno(Aluno aluno) {
            alunoDAO.inserir(aluno);
        }

        public List<Aluno> listarAlunos() {
            return alunoDAO.listarAlunos();
        }

        public Aluno buscarAlunoPorId(int id) {
            return alunoDAO.buscarAlunoPorId(id);
        }

        public void atualizarAluno(Aluno aluno) {
            alunoDAO.atualizarAluno(aluno);
        }

        public boolean removerAluno(int id) {
            return alunoDAO.removerAluno(id);
        }
    }


