package com.Senai.AQV;


import java.util.Scanner;


public class AQVView {
    public static final Scanner scanner = new Scanner(System.in);
    public static final AQVController controller = new AQVController();

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
        String id = scannerPromptInt("ID: ");
        String nome = scannerPrompt("Nome da AQV: ");
        String CPF = ScannerPrompt("CPF: ");
        String endereço = scannerPrompt("Endereço: ");
        String email = scannerPrompt("Email: ");
        String login = scannerPrompt("Login AQV: ");
        String senha = scannerPrompt("Senha: ");
        System.out.println(controller.cadastrarAQV(id, nome, CPF, endereço, email, login,senha));

    }



    private void atualizar() {
        String id = scannerPromptInt("Novo ID: ");
        int nome = scannerPromptInt("Novo nome: ");
        String CPF = ScannerPrompt("Novo CPF: ");
        String endereço = ScannerPrompt("Novo Endereço: ");
        String email = scannerPrompt("Novo Email: ");
        String login = scannerPrompt("Novo Login AQV: ");
        String senha = scannerPrompt("Novo Senha: ");
        System.out.println(controller.atualizarAQV(id, nome, CPF, endereço, email, login,senha));

    }

    private void deletar() {
        String id = scannerPrompt("Deletar ID: ");
        int nome = scannerPromptInt("Deletar nome: ");
        String CPF = ScannerPrompt("Deletar CPF: ");
        String endereço = scannerPrompt("Deletar Endereço: ");
        String email = scannerPrompt("Deletar Email: ");
        String login = scannerPrompt("Deletar Login AQV: ");
        String senha = scannerPrompt("Deletar Senha: ");
        System.out.println(controller.deletarAQV(id, nome, CPF, endereço, email, login,senha));
    }

    private void exibir() {
        for(AQV : controller.exibirAQV(id, nome, CPF, endereço, email, login,senha));
        System.out.printf("ID: %d | CPF: %d | endereço: %d | email: %d | Login: %d | senha: %d");
        h.getid(), h.get();
    }


}
