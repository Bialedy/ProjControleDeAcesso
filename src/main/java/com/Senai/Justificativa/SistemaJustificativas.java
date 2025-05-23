package com.Senai.Justificativa;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaJustificativas {

    // Classe interna para representar uma justificativa
    static class Justificativa {
        private String nomeAluno;
        private String data;
        private String motivo;

        public Justificativa(String nomeAluno, String data, String motivo) {
            this.nomeAluno = nomeAluno;
            this.data = data;
            this.motivo = motivo;
        }

        @Override
        public String toString() {
            return "Aluno: " + nomeAluno + " | Data: " + data + " | Motivo: " + motivo;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Justificativa> lista = new ArrayList<>();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- Sistema de Justificativas ---");
            System.out.println("1. Cadastrar justificativa");
            System.out.println("2. Listar justificativas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Nome do aluno: ");
                        String nome = scanner.nextLine();

                        System.out.print("Data (dd/mm/aaaa): ");
                        String data = scanner.nextLine();

                        System.out.print("Motivo do atraso: ");
                        String motivo = scanner.nextLine();

                        lista.add(new Justificativa(nome, data, motivo));
                        System.out.println("Justificativa cadastrada com sucesso!");
                        break;

                    case 2:
                        if (lista.isEmpty()) {
                            System.out.println("Nenhuma justificativa cadastrada.");
                        } else {
                            System.out.println("\n--- Lista de Justificativas ---");
                            for (Justificativa j : lista) {
                                System.out.println(j);
                            }
                        }
                        break;

                    case 0:
                        System.out.println("Encerrando o sistema.");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
            }
        }

        scanner.close();
    }
}