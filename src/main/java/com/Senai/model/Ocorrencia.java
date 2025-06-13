package com.Senai.model;
import java.time.LocalDate;
import java.time.LocalTime;


public class Ocorrencia {
    private int id;
    private String tipoOcorrencia;
    private String nomeOcorrencia;
    private LocalDate diaOcorrencia;
    private LocalTime horaOcorrencia;
    private int idAluno;

    public Ocorrencia(int id, String tipoOcorrencia, String nomeOcorrencia,
                      LocalDate diaOcorrencia, LocalTime horaOcorrencia, int idAluno) {
        this.id = id;
        this.tipoOcorrencia = tipoOcorrencia;
        this.nomeOcorrencia = nomeOcorrencia;
        this.diaOcorrencia = diaOcorrencia;
        this.horaOcorrencia = horaOcorrencia;
        this.idAluno = idAluno;
    }

    public int getId() {
        return id;
    }

    public String getTipoOcorrencia() {
        return tipoOcorrencia;
    }

    public void setTipoOcorrencia(String tipoOcorrencia) {
        this.tipoOcorrencia = tipoOcorrencia;
    }

    public String getNomeOcorrencia() {
        return nomeOcorrencia;
    }

    public void setNomeOcorrencia(String nomeOcorrencia) {
        this.nomeOcorrencia = nomeOcorrencia;
    }

    public LocalDate getDiaOcorrencia() {
        return diaOcorrencia;
    }

    public void setDiaOcorrencia(LocalDate diaOcorrencia) {
        this.diaOcorrencia = diaOcorrencia;
    }

    public LocalTime getHoraOcorrencia() {
        return horaOcorrencia;
    }

    public void setHoraOcorrencia(LocalTime horaOcorrencia) {
        this.horaOcorrencia = horaOcorrencia;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
}

