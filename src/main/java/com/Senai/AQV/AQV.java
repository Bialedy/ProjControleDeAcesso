package com.Senai.AQV;

import com.Senai.Usuario.Usuario;

import java.util.stream.DoubleStream;

public abstract class AQV extends Usuario {

    public AQV(int id, String nome, int CPF, String endereço, int telefone, String email, String login, String senha) {
        super(id, nome, CPF, endereço, telefone, email, login, senha);
    }

    @Override
    public String toString() {
        return "AQV{} \" +\n" +
                "                \"id=\" + id +\n" +
                "                \", nome='\" + nome + '\\'' +\n" +
                "                \", CPF=\" + CPF +\n" +
                "                \", endereço='\" + endereço + '\\'' +\n" +
                "                \", telefone=\" + telefone +\n" +
                "                \", email='\" + email + '\\'' +\n" +
                "                \", login='\" + login + '\\'' +\n" +
                "                \", senha='\" + senha + '\\'' +\n" +
                "                '}';\n";
    }

}
