package com.Senai.view;

import com.Senai.model.Professor;

import java.util.Scanner;

public class CoordenadorView {

    private final Scanner scanner = new Scanner(System.in);
    private final UsuarioController controller = new UsuarioController();

    public void menu(){
        String opcao;
        String menuUsuario = """
                
                --- MENU DE USUÁRIOS ---
                1. Cadastrar usuário
                2. Atualizar usuário
                3. Remover usuário
                4. Exibir usuário
                0. Voltar
                """;
        do{ System.out.println(menuUsuario);
            opcao = scanner.nextLine();

            switch (opcao){
                case "1" -> cadastrar();
                case "2" -> atualizar();
                case "3" -> remover();
                case "4" -> exibir();
                case "0" -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("0"));
    }
    private void cadastrar() {
        int id = scannerPromptInt("Cadastrar ID: ");
        String nome = scannerPrompt("Nome: ");
        int CPF = scannerPromptInt("CPF: ");
        String endereco = scannerPrompt("Endereço: ");
        int telefone = scannerPromptInt("Telefone: ");
        String email = scannerPrompt("Email: ");
        String login = scannerPrompt("Login: ");
        System.out.println(controller.cadastrarCoordenador(id, nome, CPF, endereco, telefone, email, login));
    }
    private void atualizar() {
        int id = scannerPromptInt("Cadastrar ID: ");
        String nome = scannerPrompt("Novo nome: ");
        int CPF = scannerPromptInt("Novo CPF: ");
        String endereco = scannerPrompt("Novo Endereço: ");
        int telefone = scannerPromptInt("Novo Telefone: ");
        String email = scannerPrompt("Novo Email: ");
        String login = scannerPrompt("Novo Login: ");
        System.out.println(controller.atualizarCoordenador(id, nome, CPF, endereco, telefone, email, login));
    }
    private void remover(){
        int id = scannerPromptInt("ID: ");
        System.out.println(controller.removerCoordenador(id));
    }
    private void exibir(){
        System.out.println("--- Professor ---");
        for (Professor p : controller.listarCoordenadores()){
            System.out.printf("ID: %d | Nome: %s | CPF: %d | Endereço: %s | Telefone: %d | Email: %s | Login: %s", p.getId(), p.getNome(), p.getCPF(), p.getEndereço(), p.getTelefone(), p.getEmail(), p.getLogin() );
        }
    }
    private String scannerPrompt(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    private int scannerPromptInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(scanner.nextLine());

    }

}

