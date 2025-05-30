package com.Senai.model;

import java.time.LocalTime;
import java.util.Arrays;

public class SubTurma {
    private String nomeTurma;
    private LocalTime horario;
    private Aluno[] listaAlunos;

    public SubTurma(String nomeTurma, LocalTime horario, Aluno[] listaAlunos) {
        this.nomeTurma = nomeTurma;
        this.horario = horario;
        this.listaAlunos = listaAlunos;
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
                "nomeTurma='" + nomeTurma + '\'' +
                ", horario=" + horario +
                ", listaAlunos=" + Arrays.toString(listaAlunos) +
                '}';
    }
}
