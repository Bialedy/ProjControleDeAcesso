package com.Senai.Justificativa;

import java.util.*;

public class JustificativaDAO {
    private List<Justificativa> justificativas = new ArrayList<>();

    public void adicionar(Justificativa justificativa) {
        justificativas.add(justificativa);
    }

    public List<Justificativa> listar() {
        return justificativas;
    }

    public Justificativa buscarPorId(int id) {
        for (Justificativa j : justificativas) {
            if (j.getId() == id) {
                return j;
            }
        }
        return null;
    }

    public boolean remover(int id) {
        return justificativas.removeIf(j -> j.getId() == id);
    }
}
