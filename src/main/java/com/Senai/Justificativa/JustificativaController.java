package com.Senai.Justificativa;

import java.util.List;

public class JustificativaController {
    private JustificativaDAO dao;

    public JustificativaController() {
        dao = new JustificativaDAO();
    }

    public void cadastrar(String nome, int id,  String data, String motivo) {

        Justificativa justificativa = new Justificativa(id, nome, data, motivo);
        dao.adicionar(justificativa);
        System.out.println("Justificativa cadastrada com sucesso!");
    }

    public List<Justificativa> listarTodas() {
        return dao.listar();
    }
}
