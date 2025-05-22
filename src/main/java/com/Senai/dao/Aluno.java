package com.Senai.dao;

import java.time.LocalTime;


public class Aluno extends Usuario {
private int matricula;

    public Aluno(int id, String nome, int CPF, String endereço, int telefone, String email, String login, String senha, int matricula) {
        super(id, nome, CPF, endereço, telefone, email, login, senha);
        this.matricula = matricula;

    }
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public boolean estaAtrasado(LocalTime horarioEntrada) {
        return LocalTime.now().isAfter(horarioEntrada.plusMinutes(5));
        }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                '}';
    }
}
