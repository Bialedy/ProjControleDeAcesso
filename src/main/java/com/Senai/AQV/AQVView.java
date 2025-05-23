package com.Senai.AQV;

import java.util.Scanner;


public class AQVView {
    private final Scanner scanner = new Scanner(System.in);
    private final AQVController controller = new AQVController();

    public void menu() {
        String opcao;
        String menuAQV = """
                    --- MENU AQV ---
                1. Cadastrar
                2. Atualizar 
                3. Remover
                4. Exibir
                0. Voltar
                """;
        do {

            System.out.println(menuAQV);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> cadastrar();
                case "2" -> atualizar();
                case "3" -> deletar()
                case "4" -> exibir();
                case "0" -> System.out.println("Voltar");
                default -> System.out.println("Erro");
            }

        } while (!opcao.equals("0"));
    }

    private void cadastrar() {
        int

    }

    private void atualizar() {
        int id = scannerPromptInt("");
        String ocorrencia  = scannerPrompt("");
        System.out.println(controller.atualizarocorrencia(id,ocorrencia));

    }

    private void deletar() {

    }

    private void exibir() {
        for(AQV : controller.exibirAQV());
        System.out.printf("ID: %d | Ocorrencia: ");
        h.getid(), h.get();
    }


}
