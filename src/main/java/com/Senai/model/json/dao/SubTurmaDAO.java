package com.Senai.model.json.dao;

import com.Senai.model.SubTurma;
import com.Senai.model.Turma;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SubTurmaDAO {
    private static final String caminho = "subturma.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public List<SubTurma> listarSubTurmas() {
        List<SubTurma> subturmas = new ArrayList<>();
        try (Reader reader = new FileReader(caminho)) {
            Type tipoLista = new TypeToken<List<SubTurma>>() {}.getType();
            subturmas = gson.fromJson(reader, tipoLista);
            if (subturmas == null) {
                subturmas = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return subturmas;
    }

    private void salvarSubTurmas(List<SubTurma> subturmas) {
        try {
            File arquivo = new File(caminho);
            File diretorio = arquivo.getParentFile();

            if (diretorio != null && !diretorio.exists()) {
                diretorio.mkdirs();
            }

            try (Writer writer = new FileWriter(arquivo)) {
                gson.toJson(subturmas, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserirSubTurma(SubTurma subturma) {
        List<SubTurma> subturmas = listarSubTurmas();
        subturmas.add(subturma);
        salvarSubTurmas(subturmas);
    }

    public boolean atualizarSubTurma(SubTurma subturmaAtualizada) {
        List<SubTurma> subturmas = listarSubTurmas();
        for (int i = 0; i < subturmas.size(); i++) {
            if (subturmas.get(i).getId() == subturmaAtualizada.getId()) {
                subturmas.set(i, subturmaAtualizada);
                salvarSubTurmas(subturmas);
                break;
            }
            return true;
        }
        salvarSubTurmas(subturmas);
        return false;
    }

    public boolean removerSubTurma(int id) {
        List<SubTurma> subturmas = listarSubTurmas();
        boolean removido = subturmas.removeIf(subturma -> subturma.getId() == id);
        if (removido) {
            salvarSubTurmas(subturmas);
        }
        return removido;
    }

    public SubTurma buscarSubTurmaPorId(int id) {
        for (SubTurma subturma : listarSubTurmas()) {
            if (subturma.getId() == id) {
                return subturma;
            }
        }
        return null;
    }
}
