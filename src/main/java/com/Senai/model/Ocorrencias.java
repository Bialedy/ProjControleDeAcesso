package com.Senai.model;

import java.util.Date;
import java.util.Timer;

public class Ocorrencias {
    private String tipoOcorrencia;
    private String nomeOcorrencia;
    private Date diaOcorrencia;
    private Timer horaOcorrencia;
    private int idAluno;

    public Ocorrencias(String tipoOcorrencia, String nomeOcorrencia, Date diaOcorrencia, Timer horaOcorrencia, int idAluno) {
        this.tipoOcorrencia = tipoOcorrencia;
        this.nomeOcorrencia = nomeOcorrencia;
        this.diaOcorrencia = diaOcorrencia;
        this.horaOcorrencia = horaOcorrencia;
        this.idAluno = idAluno;
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

    public Date getDiaOcorrencia() {
        return diaOcorrencia;
    }

    public void setDiaOcorrencia(Date diaOcorrencia) {
        this.diaOcorrencia = diaOcorrencia;
    }

    public Timer getHoraOcorrencia() {
        return horaOcorrencia;
    }

    public void setHoraOcorrencia(Timer horaOcorrencia) {
        this.horaOcorrencia = horaOcorrencia;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    @Override
    public String toString() {
        return "Ocorrencias{" +
                "tipoOcorrencia='" + tipoOcorrencia + '\'' +
                ", nomeOcorrencia='" + nomeOcorrencia + '\'' +
                ", diaOcorrencia=" + diaOcorrencia +
                ", horaOcorrencia=" + horaOcorrencia +
                ", idAluno=" + idAluno +
                '}';
    }
}
