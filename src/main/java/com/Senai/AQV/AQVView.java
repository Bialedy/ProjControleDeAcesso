package com.Senai.AQV;

import java.util.Scanner;

public class AQVView {
    public final Scanner scanner = new Scanner(System.in);
    public final AQVController controller = new AQVController();

    private String scannerPrompt(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private int scannerPromptInt(String message){
        while(true) {
            System.out.println(message);
            try{
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número válido.");
            }
        }
    };

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
                case "3" -> deletar();
                case "4" -> exibir();
                case "0" -> System.out.println("Voltar");
                default -> System.out.println("Erro");
            }

        } while (!opcao.equals("0"));
    }

    private void cadastrar() {
        int id = scannerPromptInt("ID: ");
        String nome = scannerPrompt("Nome da AQV: ");
        int CPF = scannerPromptInt("CPF: ");
        String endereço = scannerPrompt("Endereço: ");
        String email = scannerPrompt("Email: ");
        String login = scannerPrompt("Login AQV: ");
        String senha = scannerPrompt("Senha: ");
        System.out.println(controller.cadastrar(id, nome, CPF, endereço, email, login,senha));

    }



    private void atualizar() {
        int id = scannerPromptInt("Novo ID: ");
        String nome = scannerPrompt("Novo nome: ");
        int CPF = scannerPromptInt("Novo CPF: ");
        String endereço = scannerPrompt("Novo Endereço: ");
        String email = scannerPrompt("Novo Email: ");
        String login = scannerPrompt("Novo Login AQV: ");
        String senha = scannerPrompt("Novo Senha: ");
        System.out.println(controller.atualizar(id, nome, CPF, endereço, email, login,senha));

    }

    private void deletar() {
        int id = scannerPromptInt("Deletar ID: ");
        String nome = scannerPrompt("Deletar nome: ");
        int CPF = scannerPromptInt("Deletar CPF: ");
        String endereço = scannerPrompt("Deletar Endereço: ");
        String email = scannerPrompt("Deletar Email: ");
        String login = scannerPrompt("Deletar Login AQV: ");
        String senha = scannerPrompt("Deletar Senha: ");
        System.out.println(AQVController.deletar());
    }

    private void exibir() {
        for (AQV aqv : AQVController.exibir()){
            System.out.printf("ID: %d | CPF: %d | endereço: %d | email: %d | Login: %d | senha: %d");
        }

    }
}
