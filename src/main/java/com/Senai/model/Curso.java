package com.Senai.model;

import java.util.Arrays;

public class Curso {
    private String nomeCurso;
    private String tipoCurso;
    private int cargaHorariaCurso;
    private int tolerancia;
    private UnidadeCurricular[] listaUnidadesCurriculares;

    public Curso(String nomeCurso, String tipoCurso, int cargaHorariaCurso, int tolerancia, UnidadeCurricular[] listaUnidadesCurriculares) {
        this.nomeCurso = nomeCurso;
        this.tipoCurso = tipoCurso;
        this.cargaHorariaCurso = cargaHorariaCurso;
        this.tolerancia = tolerancia;
        this.listaUnidadesCurriculares = listaUnidadesCurriculares;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public int getCargaHorariaCurso() {
        return cargaHorariaCurso;
    }

    public void setCargaHorariaCurso(int cargaHorariaCurso) {
        this.cargaHorariaCurso = cargaHorariaCurso;
    }

    public int getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(int tolerancia) {
        this.tolerancia = tolerancia;
    }

    public UnidadeCurricular[] getListaUnidadesCurriculares() {
        return listaUnidadesCurriculares;
    }

    public void setListaUnidadesCurriculares(UnidadeCurricular[] listaUnidadesCurriculares) {
        this.listaUnidadesCurriculares = listaUnidadesCurriculares;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nomeCurso='" + nomeCurso + '\'' +
                ", tipoCurso='" + tipoCurso + '\'' +
                ", cargaHorariaCurso=" + cargaHorariaCurso +
                ", tolerancia=" + tolerancia +
                ", listaUnidadesCurriculares=" + Arrays.toString(listaUnidadesCurriculares) +
                '}';
    }
}
