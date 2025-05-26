package com.Senai.Justificativa;

import java.util.List;
import java.util.Scanner;

public class SistemaJustificativas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JustificativaController controller = new JustificativaController();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== Sistema de Justificativas ===");
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

                        System.out.print("ID do aluno: ");
                        int id = scanner.nextInt();

                        System.out.print("Data (dd/mm/aaaa):");
                        String data = scanner.nextLine();

                        System.out.print("Motivo do atraso:");
                        String motivo = scanner.nextLine();

                        controller.cadastrar(nome, id, data, motivo);
                        break;

                    case 2:
                        List<Justificativa> lista = controller.listarTodas();
                        if (lista.isEmpty()) {
                            System.out.println("Nenhuma justificativa cadastrada.");
                        } else {
                            System.out.println("\n--- Justificativas cadastradas ---");
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
