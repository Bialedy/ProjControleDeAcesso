package com.Senai.AQV;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AQVDAO {
    private final String caminho = "aqv.gson";
        private final Gson gson = new Gson();
        private final List<AQV> aqvs;

        public AQVDAO(){
            aqvs = carregar();
        }


        private List<AQV> carregar() {
            try (FileReader reader = new FileReader(caminho)) {
                Type listType = new TypeToken<List<AQV>>() {}.getType();
                return gson.fromJson(reader, listType);
            } catch (IOException e) {
                return new ArrayList<>();
            }
        }

        private void salvar(List<AQV> lista) {
            try (FileWriter writer = new FileWriter(caminho)) {
                gson.toJson(lista, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void cadastrar(AQV aqv) {
            int novoId = aqvs.stream().mapToInt(AQV::getId).max().orElse(0) + 1;
            AQV.setId(novoId);
            aqvs.add(aqv);
            salvar(aqvs);
        }

        public void atualizar(AQV aqv) {
            for (int i = 0; i < aqvs.size(); i++) {
                if (aqvs.get(i).getId() == AQV.getId()) {
                    aqvs.set(i, aqv);
                    break;
                }
            }
            salvar(aqvs);
        }

        public void deletar() {
            aqvs.removeIf(a -> a.getId() == id);
            salvar(aqvs);
        }

        public Optional<AQV> BuscarPorId(int id) {
            return aqvs.stream().filter(a -> a.getId() == id).findFirst();
        }

        public Optional<AQV> buscarPorLogin(String login) {
            return aqvs.stream().filter(a -> a.getLogin().equals(login)).findFirst();
        }

        public List<AQV> listarTodos() {
            return aqvs;
        }
    
}
