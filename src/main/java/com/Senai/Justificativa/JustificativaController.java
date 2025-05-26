package com.Senai.Justificativa;

import java.util.*;

public class JustificativaController {
    private JustificativaDAO dao = new JustificativaDAO();
    private int proximoId = 1;

    public void cadastrarJustificativa(String nome, String data, String motivo) {
        Justificativa justificativa = new Justificativa(proximoId++, nome, data, motivo);
        dao.adicionar(justificativa);
    }

    public List<Justificativa> listarJustificativas() {
        return dao.listar();
    }

    public boolean atualizarJustificativa(int id, String nome, String data, String motivo) {
        Justificativa j = dao.buscarPorId(id);
        if (j != null) {
            j.setNome(nome);
            j.setData(data);
            j.setMotivo(motivo);
            return true;
        }
        return false;
    }

    public boolean removerJustificativa(int id) {
        return dao.remover(id);
    }
}
