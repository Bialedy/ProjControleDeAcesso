package com.Senai.Justificativa;

import java.util.List;

public class JustificativaController {
    private JustificativaDAO dao;

    public JustificativaController() {
        dao = new JustificativaDAO();
    }

    public void cadastrar(int id, String nome, String data, String motivo) {
        if ( (nome == null) || nome.isEmpty() || (data == null) || data.isEmpty() || (motivo == null) || motivo.isEmpty()) {
            System.out.println("Todos os campos devem ser preenchidos.");
            return;
        }

        Justificativa justificativa = new Justificativa(id,nome, data, motivo);
        dao.salvar(justificativa);
        System.out.println("Justificativa cadastrada com sucesso!");
    }

    public List<Justificativa> listarTodas() {
        return dao.listarTodas();
    }
}
