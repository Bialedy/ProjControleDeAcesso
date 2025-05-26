package com.Senai.model.dao.json;

import com.Senai.model.Ocorrencia;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class OcorrenciaDAO {

        private static final String caminhoOcorrencia = "ocorrencias.json";
        private Gson gson = new GsonBuilder().setPrettyPrinting().create();



        private void garantirPastaExiste() {
            File arquivo = new File(caminhoOcorrencia);
            File diretorio = arquivo.getParentFile();
            if (diretorio != null && !diretorio.exists()) {
                diretorio.mkdirs();
            }
        }

        public List<Ocorrencia> listarOcorrencias() {
            List<Ocorrencia> lista = new ArrayList<>();
            try (Reader reader = new FileReader(caminhoOcorrencia)) {
                Type tipoLista = new TypeToken<List<Ocorrencia>>() {}.getType();
                lista = gson.fromJson(reader, tipoLista);
                if (lista == null) lista = new ArrayList<>();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {
                e.printStackTrace();
            }
            return lista;
        }


        private void salvarOcorrencias(List<Ocorrencia> lista) {
            garantirPastaExiste();
            try (Writer writer = new FileWriter(caminhoOcorrencia)) {
                gson.toJson(lista, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public void adicionarOcorrencia(Ocorrencia ocorrencia) {
            List<Ocorrencia> lista = listarOcorrencias();
            lista.add(ocorrencia);
            salvarOcorrencias(lista);
        }


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


        public boolean removerOcorrencia(int id) {
            List<Ocorrencia> lista = listarOcorrencias();
            boolean removido = lista.removeIf(o -> o.getId() == id);
            if (removido) {
                salvarOcorrencias(lista);
            }
            return removido;
        }


        public Ocorrencia buscarPorId(int id) {
            for (Ocorrencia o : listarOcorrencias()) {
                if (o.getId() == id) return o;
            }
            return null;
        }
    }


