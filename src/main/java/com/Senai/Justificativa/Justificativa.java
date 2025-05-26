package com.Senai.Justificativa;

import java.io.Serializable;

public class Justificativa implements Serializable {
    private int id;
    private String nome;
    private String data;
    private String motivo;

    public Justificativa(int id, String nome, String data, String motivo) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.motivo = motivo;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getData() { return data; }
    public String getMotivo() { return motivo; }

    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Data: " + data + ", Motivo: " + motivo;
    }
}
