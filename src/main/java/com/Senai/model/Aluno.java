package com.Senai.model;

import java.time.LocalTime;


public class Aluno extends Usuario {
    private int matricula;
    private String idCartaoRfid;

    public Aluno(int id, String nome, int CPF, String endereco, int telefone, String email, String login, String senha, int matricula, String idCartaoRfid) {
        super(id, nome, CPF, endereco, telefone, email, login, senha);
        this.matricula = matricula;
        this.idCartaoRfid = idCartaoRfid;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getIdCartaoRfid() {
        return idCartaoRfid;
    }

    public void setIdCartaoRfid(String idCartaoRfid) {
        this.idCartaoRfid = idCartaoRfid;
    }


    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", CPF=" + CPF +
                ", endereco='" + endereco + '\'' +
                ", telefone=" + telefone +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", matricula=" + matricula +
                ", idCartaoRfid='" + idCartaoRfid + '\'' +
                '}';
    }
}