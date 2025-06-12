package com.Senai.model.dao.json;

import com.Senai.model.Professor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProfessorDAO {
    private static final String caminho = "professores.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public List<Professor> listarProfessores() {
        List<Professor> professores = new ArrayList<>();
        try (Reader reader = new FileReader(caminho)) {
            Type tipoLista = new TypeToken<List<Professor>>() {}.getType();
            professores = gson.fromJson(reader, tipoLista);
            if (professores== null) {
                professores = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return professores;
    }

    private void salvarProfessores(List<Professor> professores) {
        try {
            File arquivo = new File(caminho);
            File diretorio = arquivo.getParentFile();

            if (diretorio != null && !diretorio.exists()) {
                diretorio.mkdirs();
            }

            try (Writer writer = new FileWriter(arquivo)) {
                gson.toJson(professores, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserirProfessor(Professor professor) {
        List<Professor> professores = listarProfessores();
        professores.add(professor);
        salvarProfessores(professores);
    }

    public boolean atualizarProfessor(Professor professorAtualizado) {
        List<Professor> professores = listarProfessores();
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getId() == professorAtualizado.getId()) {
                professores.set(i, professorAtualizado);
                salvarProfessores(professores);
                break;
            }
            return true;
        }
        salvarProfessores(professores);
        return false;
    }

    public boolean removerProfessor(int id) {
        List<Professor> professores = listarProfessores();
        boolean removido = professores.removeIf(professor -> professor.getId() == id);
        if (removido) {
            salvarProfessores(professores);
        }
        return removido;
    }
    public Professor buscarProfessorPorId(int id) {
        for (Professor professor : listarProfessores()) {
            if (professor.getId() == id) {
                return professor;
            }
        }
        return null;
    }

}


