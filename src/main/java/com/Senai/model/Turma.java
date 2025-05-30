package com.Senai.model;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

public class Turma {
    private String nomeTurma;
    private String curso;
    private int quantidadeSemestres;
    private String periodo;
    private Date dataInicio;
    private LocalTime horarioInicio;
    private SubTurma[] listaSubTurmas;

    public Turma(String nomeTurma, String curso, int quantidadeSemestres, String periodo, Date dataInicio, LocalTime horarioInicio, SubTurma[] listaSubTurmas) {
        this.nomeTurma = nomeTurma;
        this.curso = curso;
        this.quantidadeSemestres = quantidadeSemestres;
        this.periodo = periodo;
        this.dataInicio = dataInicio;
        this.horarioInicio = horarioInicio;
        this.listaSubTurmas = listaSubTurmas;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getQuantidadeSemestres() {
        return quantidadeSemestres;
    }

    public void setQuantidadeSemestres(int quantidadeSemestres) {
        this.quantidadeSemestres = quantidadeSemestres;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public SubTurma[] getListaSubTurmas() {
        return listaSubTurmas;
    }

    public void setListaSubTurmas(SubTurma[] listaSubTurmas) {
        this.listaSubTurmas = listaSubTurmas;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "nomeTurma='" + nomeTurma + '\'' +
                ", curso='" + curso + '\'' +
                ", quantidadeSemestres=" + quantidadeSemestres +
                ", periodo='" + periodo + '\'' +
                ", dataInicio=" + dataInicio +
                ", horarioInicio=" + horarioInicio +
                ", listaSubTurmas=" + Arrays.toString(listaSubTurmas) +
                '}';
    }
}
