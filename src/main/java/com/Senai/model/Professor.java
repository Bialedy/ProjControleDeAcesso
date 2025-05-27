package com.Senai.model;

import com.Senai.Usuario.Usuario;

public class Professor extends Usuario {
    private String disciplina;


    public Professor(int id, String nome, int CPF, String endereco, int telefone, String email, String login, String senha, String disciplina) {
        super(id, nome, CPF, endereco, telefone, email, login, senha);
        this.disciplina = disciplina;

    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "disciplina='" + disciplina + '\'' +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", CPF=" + CPF +
                ", endereço='" + endereço + '\'' +
                ", telefone=" + telefone +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}

