package com.Senai.view;

import com.Senai.controller.ProfessorController;
import com.Senai.model.Professor;

import java.util.List;
import java.util.Scanner;

public class ProfessorView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ProfessorController controller = new ProfessorController();

    public static void main(String[] args){
        String opcao;
        String menuProfessor = """
                
                --- MENU DE PROFESSORES ---
                 1. Listar professores
                 2. Cadastrar professor
                 3. Atualizar dados cadastrais
                 4. Remover professor
                 0. Voltar
                """;
        do{
            System.out.println(menuProfessor);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> listarProfessores();
                case "2" -> cadastrarProfessor();
                case "3" -> atualizarProfessor();
                case "4" -> removerProfessor();
                case "0" -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (!opcao.equals("0"));
    }
    private static void listarProfessores() {
        List<Professor> professores = controller.listarProfessores();
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            for (Professor professor : professores) {
                System.out.println(professor);
            }
        }
    }
    private static void cadastrarProfessor() {
        int id = Integer.parseInt(scannerPrompt("Cadastrar ID: "));
        String nome = scannerPrompt("Nome: ");
        int cpf = scannerPromptInt("CPF: ");
        String endereco = scannerPrompt("Endereço: ");
        int telefone = scannerPromptInt("Telefone: ");
        String email = scannerPrompt("Email: ");
        String login = scannerPrompt("Login: ");
        String senha = scannerPrompt("Senha: ");

        Professor novoProfessor = new Professor(id, nome, cpf, endereco, telefone, email, login, senha);
        controller.adicionarProfessor(novoProfessor);
        System.out.println("Professor cadastrado com sucesso.");
    }

}
private static void atualizarProfessor() {
    int id = scannerPromptInt("Cadastrar ID: ");
    String nome = scannerPrompt("Novo nome: ");
    int cpf = scannerPromptInt("Novo CPF: ");
    String endereco = scannerPrompt("Novo Endereço: ");
    int telefone = scannerPromptInt("Novo Telefone: ");
    String email = scannerPrompt("Novo Email: ");
    String login = scannerPrompt("Novo Login: ");
    String senha = scannerPrompt("Senha: ");
    System.out.println(controller.atualizarProfessor(id, nome, cpf, endereco, telefone, email, login, senha));
}
private static void removerProfessor(){
    int id = scannerPromptInt("Digite o ID do professor para remover: ");
    System.out.println(controller.removerProfessor(id));
}

private static String scannerPrompt(String msg) {
    System.out.print(msg);
    return scanner.nextLine();
}

private static int scannerPromptInt(String msg) {
    System.out.print(msg);
    return Integer.parseInt(scanner.nextLine());

}


