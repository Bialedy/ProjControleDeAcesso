package com.Senai.AQV;

import java.util.Scanner;
import java.util.stream.DoubleStream;

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
        int telefone = scannerPromptInt("Telefone: ");
        String email = scannerPrompt("Email: ");
        String login = scannerPrompt("Login AQV: ");
        String senha = scannerPrompt("Senha: ");

        AQV novoAQV = new AQV(id, nome, CPF, endereço, telefone, email, login, senha) {
            @Override
            public DoubleStream stream() {
                return DoubleStream.empty();
            }
        };
        controller.cadastrar(novoAQV);
        System.out.println("AQV cadastrada");

    }



    public void atualizar() {
        int id = scannerPromptInt("Atualize o ID: ");
        String nome = scannerPrompt("Novo nome: ");
        int CPF = scannerPromptInt("Novo CPF: ");
        String endereco = scannerPrompt("Novo Endereço: ");
        int telefone = scannerPromptInt("Novo Telefone: ");
        String email = scannerPrompt("Novo Email: ");
        String login = scannerPrompt("Novo Login: ");
        String senha = scannerPrompt("Senha: ");
        System.out.println(controller.atualizar(id, nome, CPF, endereco, telefone, email, login, senha));
    }


    private void deletar() {
        int id = scannerPromptInt("Deletar ID: ");
        System.out.println(controller.deletar(id));
    }

    private void exibir() {
        for (AQV aqv : controller.exibir()){
            System.out.printf("id: %d | Nome: %d | CPF: %d | Endereço: %s | Telefone: %d | email: %s | Login: %s | senha: %s",
                    aqv.getId(), aqv.getNome(), aqv.getCPF(), aqv.getEndereço(), aqv.getTelefone(), aqv.getEmail(), aqv.getLogin(), aqv.getSenha());
        }

    }
}
