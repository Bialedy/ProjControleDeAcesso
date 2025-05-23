package com.Senai.model;

import com.Senai.Usuario.Usuario;

public class Professor extends Usuario {
    private String disciplina;
    private String criar;
    private String atualizar;
    private String deletar;
    private String exibir;

    public Professor(int id, String nome, int CPF, String endereço, int telefone, String email, String login, String senha, String disciplina, String criar, String atualizar, String deletar, String exibir) {
        super(id, nome, CPF, endereço, telefone, email, login, senha);
        this.disciplina = disciplina;
        this.criar = criar;
        this.atualizar = atualizar;
        this.deletar = deletar;
        this.exibir = exibir;
    }

    public String getCriar() {
        return criar;
    }

    public void setCriar(String criar) {
        this.criar = criar;
    }

    public String getAtualizar() {
        return atualizar;
    }

    public void setAtualizar(String atualizar) {
        this.atualizar = atualizar;
    }

    public String getDeletar() {
        return deletar;
    }

    public void setDeletar(String deletar) {
        this.deletar = deletar;
    }

    public String getExibir() {
        return exibir;
    }

    public void setExibir(String exibir) {
        this.exibir = exibir;
    }


    public String getDisciplina() {
        return disciplina;
    }



}

