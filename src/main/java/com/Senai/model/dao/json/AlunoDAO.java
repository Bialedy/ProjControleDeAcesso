package com.Senai.model.dao.json;
import com.Senai.model.Aluno;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
        private static final String caminho = "alunos.json";
        private Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Lê alunos do arquivo JSON
        public List<Aluno> listarAlunos() {
            List<Aluno> alunos = new ArrayList<>();
            try (Reader reader = new FileReader(caminho)) {
                Type tipoLista = new TypeToken<List<Aluno>>() {}.getType();
                alunos = gson.fromJson(reader, tipoLista);
                if (alunos == null) {
                    alunos = new ArrayList<>();
                }
            } catch (FileNotFoundException e) {
                // se o arquivo ainda não existe, retorna lista vazia
            } catch (IOException e) {
                e.printStackTrace();
            }
            return alunos;
        }

        // Salva a lista de alunos no arquivo JSON
        private void salvarAlunos(List<Aluno> alunos) {
            try {
                File arquivo = new File(caminho);
                File diretorio = arquivo.getParentFile();

                if (diretorio != null && !diretorio.exists()) {
                    diretorio.mkdirs(); // Aqui vai criar a pasta, se não tiver um
                }

                try (Writer writer = new FileWriter(arquivo)) {
                    gson.toJson(alunos, writer);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Adiciona novo aluno
        public void inserir(Aluno aluno) {
            List<Aluno> alunos = listarAlunos();
            alunos.add(aluno);
            salvarAlunos(alunos);
        }

        // Atualiza um aluno existente (por id)
        public boolean atualizarAluno(Aluno alunoAtualizado) {
            List<Aluno> alunos = listarAlunos();
            for (int i = 0; i < alunos.size(); i++) {
                if (alunos.get(i).getId() == alunoAtualizado.getId()) {
                    alunos.set(i, alunoAtualizado);
                    salvarAlunos(alunos);
                    break;
                }
                return true;
            }
            salvarAlunos(alunos);
            return false;
        }

        // Remove um aluno pelo id
        public boolean removerAluno(int id) {
            List<Aluno> alunos = listarAlunos();
            boolean removido = alunos.removeIf(aluno -> aluno.getId() == id);
            if (removido) {
                salvarAlunos(alunos);
            }
            return removido;
        }

        // Busca pelo id
        public Aluno buscarAlunoPorId(int id) {
            for (Aluno aluno : listarAlunos()) {
                if (aluno.getId() == id) {
                    return aluno;
                }
            }
            return null;
        }
    }


