package com.Senai.AQV;

import com.Senai.Usuario.Usuario;

public class AQV extends Usuario {

    public AQV(int id, String nome, int CPF, String endereço, int telefone, String email, String login, String senha) {
        super(id, nome, CPF, endereço, telefone, email, login, senha);
    }

    @Override
    public String toString() {
        return "AQV{}";
    }
}
