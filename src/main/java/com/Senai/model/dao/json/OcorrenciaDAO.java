package com.Senai.model.dao.json;

import com.Senai.model.Ocorrencia;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class OcorrenciaDAO {

        private static final String CAMINHO_ARQUIVO = "data/ocorrencias.json";
        private Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Garante que a pasta 'data/' exista
        private void garantirDiretorio() {
            File arquivo = new File(CAMINHO_ARQUIVO);
            File diretorio = arquivo.getParentFile();
            if (diretorio != null && !diretorio.exists()) {
                diretorio.mkdirs();
            }
        }

        // Lê todas as ocorrências do JSON
        public List<Ocorrencia> listarOcorrencias() {
            List<Ocorrencia> lista = new ArrayList<>();
            try (Reader reader = new FileReader(CAMINHO_ARQUIVO)) {
                Type tipoLista = new TypeToken<List<Ocorrencia>>() {}.getType();
                lista = gson.fromJson(reader, tipoLista);
                if (lista == null) lista = new ArrayList<>();
            } catch (FileNotFoundException e) {
                // Arquivo ainda não existe, tudo bem.
            } catch (IOException e) {
                e.printStackTrace();
            }
            return lista;
        }

        // Salva a lista completa de ocorrências no JSON
        private void salvarOcorrencias(List<Ocorrencia> lista) {
            garantirDiretorio();
            try (Writer writer = new FileWriter(CAMINHO_ARQUIVO)) {
                gson.toJson(lista, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Adiciona uma nova ocorrência
        public void adicionarOcorrencia(Ocorrencia ocorrencia) {
            List<Ocorrencia> lista = listarOcorrencias();
            lista.add(ocorrencia);
            salvarOcorrencias(lista);
        }

        // Atualiza uma ocorrência existente por ID
        public boolean atualizarOcorrencia(Ocorrencia atualizada) {
            List<Ocorrencia> lista = listarOcorrencias();
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == atualizada.getId()) {
                    lista.set(i, atualizada);
                    salvarOcorrencias(lista);
                    return true;
                }
            }
            return false;
        }

        // Remove uma ocorrência pelo ID
        public boolean removerOcorrencia(int id) {
            List<Ocorrencia> lista = listarOcorrencias();
            boolean removido = lista.removeIf(o -> o.getId() == id);
            if (removido) {
                salvarOcorrencias(lista);
            }
            return removido;
        }

        // Busca uma ocorrência pelo ID
        public Ocorrencia buscarPorId(int id) {
            for (Ocorrencia o : listarOcorrencias()) {
                if (o.getId() == id) return o;
            }
            return null;
        }
    }


