package com.Senai.view;
import com.Senai.controller.OcorrenciaController;
import com.Senai.model.Ocorrencia;

import java.util.List;
import java.util.Scanner;

public class OcorrenciaView {

        private static final Scanner scanner = new Scanner(System.in);
        private static OcorrenciaController controller = new OcorrenciaController();

        public static void main(String[] args) {
            String opcao;
            String menuOcorrencia =
                    """
                            --- MENU DE OCORRÊNCIAS ---
                        1. Listar ocorrências
                        2. Cadastrar ocorrência
                        3. Atualizar ocorrência
                        4. Remover ocorrência
                        0. Voltar
                        """;

            do {
                System.out.print(menuOcorrencia);
                opcao = scanner.nextLine();

                switch (opcao) {
                    case "1" -> listar();
                    case "2" -> cadastrar();
                    case "3" -> atualizar();
                    case "4" -> remover();
                    case "0" -> System.out.println("Voltando...");
                    default -> System.out.println("Opção inválida.");
                }
            } while (!opcao.equals("0"));
        }

        private static void cadastrar() {
            int id = Integer.parseInt(scannerPrompt("ID da ocorrência: "));
            String tipo = scannerPrompt("Tipo da ocorrência: ");
            String nome = scannerPrompt("Nome da ocorrência: ");
            String data = scannerPrompt("Data da ocorrência (dd/mm/aaaa): ");
            String hora = scannerPrompt("Hora da ocorrência (hh:mm): ");
            int idAluno = Integer.parseInt(scannerPrompt("ID do aluno relacionado: "));

            Ocorrencia o = new Ocorrencia(id, tipo, nome, data, hora, idAluno);
            controller.adicionarOcorrencia(o);
            System.out.println("Ocorrência cadastrada com sucesso.");
        }

        private static void listar() {
            List<Ocorrencia> lista = controller.listarOcorrencias();
            if (lista.isEmpty()) {
                System.out.println("Nenhuma ocorrência cadastrada.");
            } else {
                for (Ocorrencia o : lista) {
                    System.out.println("\nID: " + o.getId());
                    System.out.println("Tipo: " + o.getTipoOcorrencia());
                    System.out.println("Nome: " + o.getNomeOcorrencia());
                    System.out.println("Data: " + o.getDiaOcorrencia());
                    System.out.println("Hora: " + o.getHoraOcorrencia());
                    System.out.println("ID do Aluno: " + o.getIdAluno());
                }
            }
        }

        private static void atualizar() {
            int id = Integer.parseInt(scannerPrompt("Digite o ID da ocorrência a atualizar: "));
            Ocorrencia existente = controller.buscarOcorrenciaPorId(id);

            if (existente == null) {
                System.out.println("Ocorrência não encontrada.");
                return;
            }

            String tipo = scannerPrompt("Tipo [" + existente.getTipoOcorrencia() + "]: ");
            if (!tipo.isEmpty()) existente.setTipoOcorrencia(tipo);

            String nome = scannerPrompt("Nome [" + existente.getNomeOcorrencia() + "]: ");
            if (!nome.isEmpty()) existente.setNomeOcorrencia(nome);

            String data = scannerPrompt("Data [" + existente.getDiaOcorrencia() + "]: ");
            if (!data.isEmpty()) existente.setDiaOcorrencia(data);

            String hora = scannerPrompt("Hora [" + existente.getHoraOcorrencia() + "]: ");
            if (!hora.isEmpty()) existente.setHoraOcorrencia(hora);

            String idAlunoStr = scannerPrompt("ID do Aluno [" + existente.getIdAluno() + "]: ");
            if (!idAlunoStr.isEmpty()) existente.setIdAluno(Integer.parseInt(idAlunoStr));

            controller.atualizarOcorrencia(existente);
            System.out.println("Ocorrência atualizada com sucesso.");
        }

        private static void remover() {
            int id = Integer.parseInt(scannerPrompt("Digite o ID da ocorrência a remover: "));
            if (controller.removerOcorrencia(id)) {
                System.out.println("Ocorrência removida com sucesso.");
            } else {
                System.out.println("Ocorrência não encontrada.");
            }
        }

        private static String scannerPrompt(String mensagem) {
            System.out.print(mensagem);
            return scanner.nextLine();
        }
    }
