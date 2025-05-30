package com.Senai.view;

import com.Senai.controller.AlunoController;
import com.Senai.model.Aluno;

import java.util.Scanner;
import java.util.List;

public class AlunoView {

        private static final Scanner scanner = new Scanner(System.in);
        private static AlunoController controller = new AlunoController(); // você ainda vai criar essa classe

        public static void main(String[] args) {
            String opcao;
            String menuAluno =
                    """
                                --- MENU DE Alunos ---
                            1. Listar alunos
                            2. Cadastrar aluno
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

        private static void cadastrar() {
            int id = Integer.parseInt(scannerPrompt("ID: "));
            String nome = scannerPrompt("Nome: ");
            int cpf = Integer.parseInt(scannerPrompt("CPF (somente números): "));
            String endereco = scannerPrompt("Endereço: ");
            int telefone = Integer.parseInt(scannerPrompt("Telefone): "));
            String email = scannerPrompt("Email: ");
            String login = scannerPrompt("Login: ");
            String senha = scannerPrompt("Senha: ");
            int matricula = Integer.parseInt(scannerPrompt("Matrícula: "));
            String rfid = scannerPrompt("ID do Cartão RFID: ");

            Aluno novoAluno = new Aluno(id, nome, cpf, endereco, telefone, email, login, senha, matricula, rfid);
            controller.adicionarAluno(novoAluno);
            System.out.println("Aluno cadastrado com sucesso.");
        }

        private static void listar() {
            List<Aluno> alunos = controller.listarAlunos();
            if (alunos.isEmpty()) {
                System.out.println("Nenhum aluno cadastrado.");
            } else {
                for (Aluno aluno : alunos) {
                    System.out.println(aluno);
                }
            }
        }

        private static void atualizar() {
            int id = Integer.parseInt(scannerPrompt("Digite o ID do aluno a atualizar: "));
            Aluno existente = controller.buscarAlunoPorId(id);
            if (existente == null) {
                System.out.println("Aluno não encontrado.");
                return;
            }

            String nome = scannerPrompt("Nome [" + existente.getNome() + "]: ");
            if (!nome.isEmpty()) existente.setNome(nome);

            String email = scannerPrompt("Email [" + existente.getEmail() + "]: ");
            if (!email.isEmpty()) existente.setEmail(email);

            String endereco = scannerPrompt("Endereço [" + existente.getEndereço() + "]: ");
            if (!endereco.isEmpty()) existente.setEndereço(endereco);

            controller.atualizarAluno(existente);
            System.out.println("Dados atualizados.");
        }

        private static void remover() {
            int id = Integer.parseInt(scannerPrompt("Digite o ID do aluno para remover: "));
            if (controller.removerAluno(id)) {
                System.out.println("Aluno removido com sucesso.");
            } else {
                System.out.println("Aluno não encontrado.");
            }
        }

        private static void atribuirRfid() {
            int id = Integer.parseInt(scannerPrompt("Digite o ID do aluno: "));
            Aluno aluno = controller.buscarAlunoPorId(id);
            if (aluno == null) {
                System.out.println("Aluno não encontrado.");
                return;
            }

            String novoRfid = scannerPrompt("Novo ID de cartão RFID: ");
            aluno.setIdCartaoRfid(novoRfid);
            controller.atualizarAluno(aluno);
            System.out.println("Cartão RFID atualizado.");
        }

        private static String scannerPrompt(String msg) {
            System.out.print(msg);
            return scanner.nextLine();
        }
    }
