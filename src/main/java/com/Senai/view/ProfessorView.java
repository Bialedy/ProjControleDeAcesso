package com.Senai.view;

import com.Senai.controller.ProfessorController;
import com.Senai.model.Professor;

import java.util.List;
import java.util.Scanner;

public class ProfessorView {
    private static final Scanner scanner = new Scanner(System.in);
    private static ProfessorController controller = new ProfessorController();

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
                case "1" -> listar();
                case "2" -> cadastrarProfessor();
                case "3" -> atualizarProfessor();
                case "4" -> removerProfessor();
                case "0" -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (!opcao.equals("0"));
    }
    private static void listar() {
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
        System.out.println(controller.cadastrarProfessor(id, nome, cpf, endereco, telefone, email, login));

        Professor novoProfessor = new Professor(id, nome, cpf, endereco, telefone, email, login, senha, matricula, rfid);
        controller.adicionarProfesor(novoProfessor);
        System.out.println("Aluno cadastrado com sucesso.");
    }
    }
    private void atualizarProfessor() {
        int id = scannerPromptInt("Cadastrar ID: ");
        String nome = scannerPrompt("Novo nome: ");
        int cpf = scannerPromptInt("Novo CPF: ");
        String endereco = scannerPrompt("Novo Endereço: ");
        int telefone = scannerPromptInt("Novo Telefone: ");
        String email = scannerPrompt("Novo Email: ");
        String login = scannerPrompt("Novo Login: ");
        String senha = scannerPrompt("Senha: ");
        System.out.println(controller.atualizarUsuario(id, nome, cpf, endereco, telefone, email, login));
    }
    private void removerProfessor(){
        int id = scannerPromptInt("Digite o ID do professor para remover: ");
        System.out.println(controller.removerUsuario(id));
    }
    private void exibirProfessor(){
        System.out.println("--- Professor ---");
        for (Professor p : controller.listarProfessores()){
            System.out.printf("ID: %d | Nome: %s | CPF: %d | Endereço: %s | Telefone: %d | Email: %s | Login: %s", p.getId(), p.getNome(), p.getCPF(), p.getEndereço(), p.getTelefone(), p.getEmail(), p.getLogin() );
        }
    }
    private static String scannerPrompt(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    private static int scannerPromptInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(scanner.nextLine());

    }
}
