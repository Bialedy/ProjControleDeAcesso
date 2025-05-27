package com.Senai.view;

import com.Senai.controller.CoordenadorController;
import com.Senai.model.Coordenador;
import com.Senai.model.Professor;

import java.util.List;
import java.util.Scanner;

public class CoordenadorView {

    private static  final Scanner scanner = new Scanner(System.in);
    private static final CoordenadorController controller = new CoordenadorController();

    public static void main(String[] args){
        String opcao;
        String menuCoordenador = """
                
                --- MENU DE COORDENADORES ---
                1. Cadastrar coordenadores
                2. Atualizar coordenadores
                3. Remover coordenadores
                4. Exibir coordenadores
                0. Voltar
                """;
        do{ System.out.println(menuCoordenador);
            opcao = scanner.nextLine();

            switch (opcao){
                case "1" -> listarCoordenadores();
                case "2" -> cadastrarCoordenador();
                case "3" -> atualizarCoordenador();
                case "4" -> removerCoordenador();
                case "0" -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("0"));
    }
    private static void cadastrarCoordenador() {
        int id = scannerPromptInt("Cadastrar ID: ");
        String nome = scannerPrompt("Nome: ");
        int cpf = scannerPromptInt("CPF: ");
        String endereco = scannerPrompt("Endereço: ");
        int telefone = scannerPromptInt("Telefone: ");
        String email = scannerPrompt("Email: ");
        String login = scannerPrompt("Login: ");
        String senha = scannerPrompt("Senha: ");

        Coordenador novoCoordenador = new Coordenador(id, nome, cpf, endereco, telefone, email, login, senha);
        controller.adicionarCoordenador(novoCoordenador);
        System.out.println("Coordenador cadastrado com sucesso.");
    }
    private static void listarCoordenadores() {
        List<Coordenador> coordenadores = controller.listarCoordenadores();
        if (coordenadores.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Coordenador coordenador : coordenadores) {
                System.out.println(coordenador);
            }
        }
    }
    private static void atualizarCoordenador() {
        int id = scannerPromptInt("Cadastrar ID: ");
        String nome = scannerPrompt("Novo nome: ");
        int CPF = scannerPromptInt("Novo CPF: ");
        String endereco = scannerPrompt("Novo Endereço: ");
        int telefone = scannerPromptInt("Novo Telefone: ");
        String email = scannerPrompt("Novo Email: ");
        String login = scannerPrompt("Novo Login: ");
        String senha = scannerPrompt("Senha: ");
        System.out.println(controller.atualizarCoordenador(id, nome, CPF, endereco, telefone, email, login, senha));
    }
    private static void removerCoordenador(){
        int id = scannerPromptInt("ID: ");
        System.out.println(controller.removerCoordenador(id));
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

