package com.Senai.model;

import com.Senai.Usuario.Usuario;

public class Coordenador extends Usuario {
    public Coordenador(int id, String nome, int CPF, String endereço, int telefone, String email, String login, String senha) {
        super(id, nome, CPF, endereço, telefone, email, login, senha);

    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", CPF=" + CPF +
                ", endereço='" + endereço + '\'' +
                ", telefone=" + telefone +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
