package com.Senai.controller;
import com.Senai.model.Ocorrencia;
import com.Senai.model.dao.json.OcorrenciaDAO;

import java.util.List;

public class OcorrenciaController {


    private OcorrenciaDAO ocorrenciaDAO;

    public OcorrenciaController() {
        this.ocorrenciaDAO = new OcorrenciaDAO();
    }

    public void adicionarOcorrencia(Ocorrencia ocorrencia) {
        ocorrenciaDAO.adicionarOcorrencia(ocorrencia);
    }

    public List<Ocorrencia> listarOcorrencias() {
        return ocorrenciaDAO.listarOcorrencias();
    }

    public Ocorrencia buscarOcorrenciaPorId(int id) {
        return ocorrenciaDAO.buscarPorId(id);
    }

    public void atualizarOcorrencia(Ocorrencia ocorrencia) {
        ocorrenciaDAO.atualizarOcorrencia(ocorrencia);
    }

    public boolean removerOcorrencia(int id) {
        return ocorrenciaDAO.removerOcorrencia(id);
    }
}
