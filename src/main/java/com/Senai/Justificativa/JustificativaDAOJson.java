package com.Senai.Justificativa;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JustificativaDAOJson {
        private static final String FILE_NAME = "justificativas.json";
        private List<Justificativa> justificativas;
        private Gson gson = new Gson();
        public JustificativaDAOJson() {
            justificativas = carregar();
        }

        private List<Justificativa> carregar() {
            try (Reader reader = new FileReader(FILE_NAME)) {
                Type listType = new TypeToken<List<Justificativa>>() {}.getType();
                return gson.fromJson(reader, listType);
            } catch (IOException e) {
                return new ArrayList<>();
            }
        }

        private void salvar() {
            try (Writer writer = new FileWriter(FILE_NAME)) {
                gson.toJson(justificativas, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void adicionar(Justificativa justificativa) {
            justificativas.add(justificativa);
            salvar();
        }

        public boolean remover(int id) {
            boolean removido = justificativas.removeIf(j -> j.getId() == id);
            if (removido) salvar();
            return removido;
        }

        public Justificativa buscarPorId(int id) {
            return justificativas.stream().filter(j -> j.getId() == id).findFirst().orElse(null);
        }

        public boolean atualizar(Justificativa nova) {
            for (int i = 0; i < justificativas.size(); i++) {
                if (justificativas.get(i).getId() == nova.getId()) {
                    justificativas.set(i, nova);
                    salvar();
                    return true;
                }
            }
            return false;
        }

        public List<Justificativa> listar() {
            return justificativas;
        }
    }


