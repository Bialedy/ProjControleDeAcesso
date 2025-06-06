package com.Senai.AQV;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AQVDAO {
    private static final String caminho = "aqv.gson";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();



    public void salvar(AQV aqv) {
            try {
                File arquivo = new File(caminho);
                File diretorio = arquivo.getParentFile();

                if (diretorio != null && !diretorio.exists()) {
                    diretorio.mkdirs();
                }

                try (Writer writer = new FileWriter(arquivo)) {
                    gson.toJson(aqv, writer);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public List<AQV> listar() {
        List<AQV> aqv = new ArrayList<>();
        try (Reader reader = new FileReader(caminho)) {
            Type tipoLista = new TypeToken<List<AQV>>() {}.getType();
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


    public void cadastrar(AQV aqv) {
        List<AQV> aqvs = listar();
        aqvs.add(aqv);
        salvar(aqv);
    }

    public boolean atualizar(AQV aqv) {
        List<AQV> aqvs = listar();
        for (int i = 0; i < aqvs.size(); i++) {
            if (aqvs.get(i).getId() == aqv.getId()) {
                aqvs.set(i, aqv);
                salvar(aqv);
                break;
            }
            return true;
        }
        salvar(aqv);
        return false;
    }

    public boolean deletar(int id, AQV AQV) {
        List<AQV> aqvs = listar();
        boolean remove = aqvs.removeIf(aqv -> aqv.getId() == id);
        if (remove) {
            salvar(AQV);
        }
        return remove;
    }


    public AQV BuscarPorId(int id, AQV AQV) {
            for (AQV aqv : listar()) {
                if(aqv.getId() == id) {
                    return AQV;
                }
            }
            return null;
    }

}
