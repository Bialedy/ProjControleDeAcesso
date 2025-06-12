package com.Senai.model.json.dao;

import com.Senai.model.Curso;
import com.Senai.model.Turma;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {
    private static final String caminho = "turma.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public List<Turma> listarTurmas() {
        List<Turma> turmas = new ArrayList<>();
        try (Reader reader = new FileReader(caminho)) {
            Type tipoLista = new TypeToken<List<Turma>>() {}.getType();
            turmas = gson.fromJson(reader, tipoLista);
            if (turmas == null) {
                turmas = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return turmas;
    }

    private void salvarTurmas(List<Turma> turmas) {
        try {
            File arquivo = new File(caminho);
            File diretorio = arquivo.getParentFile();

            if (diretorio != null && !diretorio.exists()) {
                diretorio.mkdirs();
            }

            try (Writer writer = new FileWriter(arquivo)) {
                gson.toJson(turmas, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserirTurma(Turma turma) {
        List<Turma> turmas = listarTurmas();
        turmas.add(turma);
        salvarTurmas(turmas);
    }

    public boolean atualizarTurma(Turma turmaAtualizada) {
        List<Turma> turmas = listarTurmas();
        for (int i = 0; i < turmas.size(); i++) {
            if (turmas.get(i).getId() == turmaAtualizada.getId()) {
                turmas.set(i, turmaAtualizada);
                salvarTurmas(turmas);
                break;
            }
            return true;
        }
        salvarTurmas(turmas);
        return false;
    }

    public boolean removerTurma(int id) {
        List<Turma> turmas = listarTurmas();
        boolean removido = turmas.removeIf(turma -> turma.getId() == id);
        if (removido) {
            salvarTurmas(turmas);
        }
        return removido;
    }

    public Turma buscarTurmaPorId(int id) {
        for (Turma turma : listarTurmas()) {
            if (turma.getId() == id) {
                return turma;
            }
        }
        return null;
    }
}
