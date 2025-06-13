package com.Senai.AQV;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AQVDAO {
    private static final String caminho = "aqv.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private boolean salvarTodosAQVs(AQV aqvs) {
        try (Writer writer = new FileWriter(caminho)) {
            gson.toJson(aqvs, writer);
            return true;
        } catch (IOException e) {
            System.err.println("Erro ao salvar AQVs no arquivo: " + e.getMessage());
            e.printStackTrace(); // Para depuração
            return false;
        }
    }


    public List<AQV> exibir(AQV aqv) {
        List<AQV> aqv = new ArrayList<>();
        try (Reader reader = new FileReader(caminho)) {
            Type tipoLista = new TypeToken<List<AQV>>() {
            }.getType();
            aqv = gson.fromJson(reader, tipoLista);
            if (aqv == null) {
                aqv = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return aqv;
    }


    public boolean cadastrar(AQV aqv) {
        List<AQV> aqvs = exibir(aqv);
        aqvs.add(aqv);
        salvarTodosAQVs(aqv);
        return salvarTodosAQVs(aqvs);
    }

    public boolean atualizar(AQV aqv) {
        List<AQV> aqvs = exibir(aqv);
        for (int i = 0; i < aqvs.size(); i++) {
            if (aqvs.get(i).getId() == aqv.getId()) {
                aqvs.set(i, aqv);
                salvarTodosAQVs(aqv);
                break;
            }
            return true;
        }
        salvarTodosAQVs(aqv);
        return false;
    }

    public boolean deletar(int id, AQV aqv) {
        List<AQV> aqvs = exibir(aqv);
        boolean remove = aqvs.removeIf(AQV -> aqv.getId() == id);
        if (remove) {
            salvarTodosAQVs(aqv);
        }
        return remove;
    }


    public AQV BuscarPorId(int id) {
        for (AQV aqv : exibir(aqv)) {
            if (aqv.getId() == id) {
                return aqv;
            }
        }
        return null;
    }
}
