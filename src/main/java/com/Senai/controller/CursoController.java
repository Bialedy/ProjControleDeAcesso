package com.Senai.controller;

import com.Senai.model.Curso;
import com.Senai.model.json.dao.CursoDAO;
import java.util.List;

public class CursoController {
    private CursoDAO cursoDAO;

    public CursoController() {
        this.cursoDAO = new CursoDAO();
    }

    public void adicionarCurso(Curso curso) {
        cursoDAO.inserirCurso(curso);
    }

    public List<Curso> listarCursos() {
        return cursoDAO.listarCursos();
    }

    public Curso buscarCursoPorId(int id) {
        return cursoDAO.buscarCursoPorId(id);
    }

    public void atualizarCurso(Curso curso) {
        cursoDAO.atualizarCurso(curso);
    }

    public boolean removerCurso(int id) {
        return cursoDAO.removerCurso(id);
    }
}
