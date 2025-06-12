package com.Senai.model;

import java.time.LocalTime;
import java.util.Arrays;

public class SubTurma {
    private int id;
    private String nomeTurma;
    private LocalTime horario;
    private Aluno[] listaAlunos;

    public SubTurma(int id, String nomeTurma, LocalTime horario, Aluno[] listaAlunos) {
        this.id = id;
        this.nomeTurma = nomeTurma;
        this.horario = horario;
        this.listaAlunos = listaAlunos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Aluno[] getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(Aluno[] listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    @Override
    public String toString() {
        return "SubTurma{" +
                "id=" + id +
                ", nomeTurma='" + nomeTurma + '\'' +
                ", horario=" + horario +
                ", listaAlunos=" + Arrays.toString(listaAlunos) +
                '}';
    }
}
