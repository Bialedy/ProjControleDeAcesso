package com.Senai.model;
import java.time.LocalDate;
import java.time.LocalTime;

public class Ocorrencia {
    private int id;
    private String tipoOcorrencia;
    private String nomeOcorrencia;
    private String diaOcorrencia;
    private String horaOcorrencia;
    private int idAluno;

    public Ocorrencia(int id, String tipoOcorrencia, String nomeOcorrencia, String diaOcorrencia, String horaOcorrencia, int idAluno) {
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

    public void setId(int id) {
        this.id = id;
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

    public String getDiaOcorrencia() {
        return diaOcorrencia;
    }

    public void setDiaOcorrencia(String diaOcorrencia) {
        this.diaOcorrencia = diaOcorrencia;
    }

    public String getHoraOcorrencia() {
        return horaOcorrencia;
    }

    public void setHoraOcorrencia(String horaOcorrencia) {
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
        return "Ocorrencia{" +
                "id=" + id +
                ", tipoOcorrencia='" + tipoOcorrencia + '\'' +
                ", nomeOcorrencia='" + nomeOcorrencia + '\'' +
                ", diaOcorrencia='" + diaOcorrencia + '\'' +
                ", horaOcorrencia='" + horaOcorrencia + '\'' +
                ", idAluno=" + idAluno +
                '}';
    }
}

