package com.Senai.model.dao.json;


import com.Senai.model.Coordenador;
import com.Senai.model.Professor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import java.io.*;
import java.lang.reflect.Type;
import java.util.*;


public class CoordenadorDAO {
    private static final String caminho = "coordenadores.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public List<Coordenador> listarCoordenadores() {
        List<Coordenador> coordenadores = new ArrayList<>();
        try (Reader reader = new FileReader(caminho)) {
            Type tipoLista = new TypeToken<List<Coordenador>>() {}.getType();
            coordenadores = gson.fromJson(reader, tipoLista);
            if (coordenadores == null) {
                coordenadores = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return coordenadores;
    }

    private void salvarCoordenadores(List<Coordenador> coordenadores) {
        try {
            File arquivo = new File(caminho);
            File diretorio = arquivo.getParentFile();

            if (diretorio != null && !diretorio.exists()) {
                diretorio.mkdirs();
            }

            try (Writer writer = new FileWriter(arquivo)) {
                gson.toJson(coordenadores, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserirCoordenadores(Coordenador coordenador) {
        List<Coordenador> coordenadores = listarCoordenadores();
        coordenadores.add(coordenador);
        salvarCoordenadores(coordenadores);
    }

    public boolean atualizarCoordenador(Coordenador coordenadorAtualizado) {
        List<Coordenador> coordenadores = listarCoordenadores();
        for (int i = 0; i < coordenadores.size(); i++) {
            if (coordenadores.get(i).getId() == coordenadorAtualizado.getId()) {
                coordenadores.set(i, coordenadorAtualizado);
                salvarCoordenadores(coordenadores);
                break;
            }
            return true;
        }
        salvarCoordenadores(coordenadores);
        return false;
    }

    public boolean removerCoordenador(int id) {
        List<Coordenador> coordenadores = listarCoordenadores();
        boolean removido = coordenadores.removeIf(coordenador -> coordenador.getId() == id);
        if (removido) {
            salvarCoordenadores(coordenadores);
        }
        return removido;
    }
    public Coordenador buscarCoordenadorPorId(int id) {
        for (Coordenador coordenador : listarCoordenadores()) {
            if (coordenador.getId() == id) {
                return coordenador;
            }
        }
        return null;
    }

}