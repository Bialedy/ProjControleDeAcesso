package com.Senai.Justificativa;

import com.Senai.Usuario.Usuario;

public class Justificativa extends Usuario {
        public Justificativa(int id, String nome, String login, String senha) {
            super(id, nome, login, senha);

        }

        @Override
        public int getId() {
            return super.getId();
        }

        @Override
        public void setId(int id) {
            super.setId(id);
        }

        @Override
        public String getNome() {
            return super.getNome();
        }

        @Override
        public void setNome(String nome) {
            super.setNome(nome);
        }

        @Override
        public String getLogin() {
            return super.getLogin();
        }

        @Override
        public void setLogin(String login) {
            super.setLogin(login);
        }

        @Override
        public String getSenha() {
            return super.getSenha();
        }

        @Override
        public void setSenha(String senha) {
            super.setSenha(senha);
        }

        @Override
        public String toString() {
            return "SistemaJustificativa{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", login='" + login + '\'' +
                    ", senha='" + senha + '\'' +
                    '}';
        }


    }
