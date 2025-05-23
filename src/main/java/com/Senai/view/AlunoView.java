package com.Senai.view;

import java.util.Scanner;


public class AlunoView {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        String opcao;
        String menuAluno =
                """
                            --- MENU DE Alunos ---
                        1. Listar alunos
                        2. Cadastrar Alunos
                        3. Atualizar dados cadastrais
                        4. Remover aluno
                        5. Atribuir/alterar RFID
                        0. Voltar
                        """;

        do {

            System.out.print(menuAluno);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> listar();
                case "2" -> cadastrar();
                case "3" -> atualizar();
                case "4" -> remover();
                case "5" -> atribuirRfid();
                case "0" -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("0"));
    }
    private void cadastrar() {
        String nome = scannerPrompt("Nome: ");

        String login = scannerPrompt("Login: ");
        String senha = scannerPrompt("Senha: ");
        String dadoExtra = tipo.equals("1") ? scannerPrompt("ID do cartão RFID: ") : scannerPrompt("Disciplina: ");
        System.out.println(controller.cadastrarUsuario(tipo, nome, dadoExtra,login,senha));
    }



    private String scannerPrompt(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }
}