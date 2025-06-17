package com.Senai.AQV;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AQVDAO {
    private static final String caminho = "aqv.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private boolean salvarTodosAQVs(List<AQV> aqvs) {
        try (Writer writer = new FileWriter(caminho)) {
            gson.toJson(aqvs, writer);
            return true;
        } catch (IOException e) {
            System.err.println("Erro ao salvar AQVs no arquivo: " + e.getMessage());
            e.printStackTrace(); // Para depuração
            return false;
        }
    }


    public List<AQV> exibir() {
        List<AQV> aqvs = new ArrayList<>();
        try (Reader reader = new FileReader(caminho)) {
            Type tipoLista = new TypeToken<List<AQV>>() {
            }.getType();
            aqvs = gson.fromJson(reader, tipoLista);
            if (aqvs == null) {
                aqvs = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return aqvs;
    }


    public boolean cadastrar(AQV aqv) {
        List<AQV> aqvs = exibir();
        aqvs.add(aqv);
        return salvarTodosAQVs(aqvs);
    }

    public boolean atualizar(AQV aqv) {
        List<AQV> aqvs = exibir();
        boolean atualizado = false;
        for (int i = 0; i < aqvs.size(); i++) {
            if (aqvs.get(i).getId() == aqv.getId()) {
                aqvs.set(i, aqv);
                atualizado = true;
                break;
            }
        }
        if (atualizado) {
            salvarTodosAQVs(aqvs);
        }
        return false;
    }

    public boolean deletar(int id) {
        List<AQV> aqvs = exibir();
        boolean remove = aqvs.removeIf(aqv -> aqv.getId() ==id);
        if (remove) {
            salvarTodosAQVs(aqvs);
        }
        return remove;
    }


    public AQV BuscarPorId(int id) {
        for (AQV aqv : exibir()) {
            if (aqv.getId() == id) {
                return aqv;
            }
        }
        return null;
    }
}
