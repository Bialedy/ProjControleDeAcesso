package com.Senai.AQV;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AQVDAO {
    private static final String caminho = "aqv.gson";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();


        public List<AQV> carregar() {
            try (FileReader reader = new FileReader(caminho)) {
                Type listType = new TypeToken<List<AQV>>() {}.getType();
                return gson.fromJson(reader, listType);
            } catch (IOException e) {
                return new ArrayList<>();
            }
        }

        public boolean salvar(List<AQV> lista) {
            try (FileWriter writer = new FileWriter(caminho)) {
                gson.toJson(lista, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

        public void cadastrar(AQV aqv) {
            List<AQV> aqv = listarTodos();
            aqv.add(AQV);
            salvar(aqv);
        }

        public boolean atualizar(AQV aqv) {
            List<AQV> aqv = listarTodos();
            for (int i = 0; i < aqv.size(); i++) {
                if (aqv.get(i).getId() ==  id) {
                    aqv.set(i, aqv);
                    salvar(aqv);
                    break;
                }
                return true;
            }
            salvar(aqv);
            return false;
        }


        public boolean deletar(int id) {
            List<AQV> aqv = listarTodos();
            boolean remove = aqv.removeIf(aqv -> aqv.getId() == id);
            if (remove) {
                salvar(aqv);
            }
            return remove;
        }



        public Optional<AQV> BuscarPorId(int id) {
            return aqv.stream().filter(a -> a.getId() == id).findFirst();
        }

        public Optional<AQV> buscarPorLogin(String login) {
            return aqv.stream().filter(a -> a.getLogin().equals(login)).findFirst();
        }

        public List<AQV> listarTodos() {
            return aqvs;
        }


}
