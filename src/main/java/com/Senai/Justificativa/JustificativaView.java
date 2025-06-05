package com.Senai.Justificativa;

import java.util.*;

public class JustificativaView {
    private Scanner scanner = new Scanner(System.in);

    public int exibirMenu() {
        System.out.println("1. Cadastrar justificativa");
        System.out.println("2. Listar justificativas");
        System.out.println("3. Atualizar justificativa");
        System.out.println("4. Remover justificativa");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public String solicitar(String campo) {
        System.out.print("Digite " + campo + ": ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public int solicitarId() {
        System.out.print("Digite o ID da justificativa: ");
        return scanner.nextInt();
    }

    public void exibirJustificativas(List<Justificativa> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhuma justificativa cadastrada.");
        } else {
            for (Justificativa j : lista) {
                System.out.println(j);
            }
        }
    }

    public void mostrarMensagem(String msg) {
        System.out.println(msg);
    }
}
