package com.Senai.Justificativa;

import java.io.*;
import java.util.*;

import com.Senai.Justificativa.Justificativa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JustificativaDAO {
    private final String ARQUIVO = "justificativas.json";
    private final Gson gson;

    public JustificativaDAO() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void salvar(Justificativa justificativa) {
        List<Justificativa> lista = listarTodas();
        lista.add(justificativa);
        salvarLista(lista);
    }

    public List<Justificativa> listarTodas() {
        try (Reader reader = new FileReader(ARQUIVO)) {
            return gson.fromJson(reader, new TypeToken<List<Justificativa>>() {}.getType());
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void salvarLista(List<Justificativa> lista) {
        try (Writer writer = new FileWriter(ARQUIVO)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
