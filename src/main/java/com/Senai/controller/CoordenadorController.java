package com.Senai.controller;

import com.Senai.model.Coordenador;
import com.Senai.model.Professor;
import com.Senai.model.dao.json.CoordenadorDAO;
import com.Senai.model.dao.json.ProfessorDAO;

import java.util.List;

public class CoordenadorController {

    public CoordenadorDAO coordenadorDAO;

    public CoordenadorController() {
        this.coordenadorDAO = new CoordenadorDAO();
    }

    public boolean cadastrarCoordenador(Coordenador coordenador) {
        coordenadorDAO.inserirCoordenadores(coordenador);
        return false;
    }

    public List<Coordenador> listarCoordenadores() {
        return coordenadorDAO.listarCoordenadores();
    }


    public void atualizarCoordenador(Coordenador coordenador) {
        coordenadorDAO.atualizarCoordenador(coordenador);
    }

    public boolean removerCoordenador(int id) {

        return coordenadorDAO.removerCoordenador(id);
    }

    public boolean atualizarCoordenador(int id, String nome, int cpf, String endereco, int telefone, String email, String login, String senha) {
    return coordenadorDAO.removerCoordenador(id);
    }


    public void adicionarCoordenador(Coordenador novoCoordenador) {
    }
}


