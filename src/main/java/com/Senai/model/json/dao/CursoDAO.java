package com.Senai.model.json.dao;

import com.Senai.model.Curso;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProfessorDAO {
    private static final String caminho = "curso.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public List<Curso> listarCursos() {
        List<Curso> cursos = new ArrayList<>();
        try (Reader reader = new FileReader(caminho)) {
            Type tipoLista = new TypeToken<List<Curso>>() {}.getType();
            cursos = gson.fromJson(reader, tipoLista);
            if (cursos== null) {
                cursos = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cursos;
    }

    private void salvarCursos(List<Curso> cursos) {
        try {
            File arquivo = new File(caminho);
            File diretorio = arquivo.getParentFile();

            if (diretorio != null && !diretorio.exists()) {
                diretorio.mkdirs();
            }

            try (Writer writer = new FileWriter(arquivo)) {
                gson.toJson(cursos, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserirCurso(Curso curso) {
        List<Curso> cursos = listarCursos();
        cursos.add(curso);
        salvarCursos(cursos);
    }

    public boolean atualizarCurso(Curso cursoAtualizado) {
        List<Curso> cursos = listarCursos();
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getId() == cursoAtualizado.getId()) {
                cursos.set(i, cursoAtualizado);
                salvarCursos(cursos);
                break;
            }
            return true;
        }
        salvarCursos(cursos);
        return false;
    }

    public boolean removerCurso(int id) {
        List<Curso> cursos = listarCursos();
        boolean removido = cursos.removeIf(curso -> curso.getId() == id);
        if (removido) {
            salvarCursos(cursos);
        }
        return removido;
    }
    public Curso buscarCursoPorId(int id) {
        for (Curso curso : listarCursos()) {
            if (curso.getId() == id) {
                return curso;
            }
        }
        return null;
    }

}