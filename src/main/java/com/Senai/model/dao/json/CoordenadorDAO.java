package com.Senai.model.dao.json;


import com.Senai.model.Coordenador;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;


public class CoordenadorDAO {
    private final String caminho = "coordenadores.json";
    private final Gson gson = new Gson();
    private final List<Coordenador> coordenadores;

    public CoordenadorDAO(){
        coordenadores = carregar();
    }
    private List<Coordenador> carregar() {
        try (FileReader reader = new FileReader(caminho)) {
            Type listType = new TypeToken<List<Coordenador>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public Optional<Coordenador> buscarPorLogin(String login) {
        return coordenadores.stream().filter(a -> a.getLogin().equals(login)).findFirst();
    }

    public List<Coordenador> listarTodos() {
        return coordenadores;
    }

    public void inserir(Coordenador coord) {
        int novoId = coordenadores.stream().mapToInt(Coordenador::getId).max().orElse(0) + 1;
        coord.setId(novoId);
        coordenadores.add(coord);
        salvar(coordenadores);
    }

    private void salvar(List<Coordenador> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}