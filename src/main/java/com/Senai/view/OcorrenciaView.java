package com.Senai.view;
import com.Senai.controller.OcorrenciaController;
import com.Senai.model.Ocorrencia;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.List;
import java.util.Scanner;

public class OcorrenciaView {

        private static final Scanner scanner = new Scanner(System.in);
        private static final OcorrenciaController controller = new OcorrenciaController();
        private static final DateTimeFormatter FORMATADOR_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        private static final DateTimeFormatter FORMATADOR_HORA = DateTimeFormatter.ofPattern("HH:mm");

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

            LocalDate data = null;
            while (data == null) {
                try {
                    String dataStr = scannerPrompt("Data da ocorrência (dd/MM/yyyy): ");
                    data = LocalDate.parse(dataStr, FORMATADOR_DATA);
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data inválido. Tente novamente.");
                }
            }

            LocalTime hora = null;
            while (hora == null) {
                try {
                    String horaStr = scannerPrompt("Hora da ocorrência (HH:mm): ");
                    hora = LocalTime.parse(horaStr, FORMATADOR_HORA);
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de hora inválido. Tente novamente.");
                }
            }

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
                    System.out.println("Data: " + o.getDiaOcorrencia().format(FORMATADOR_DATA));
                    System.out.println("Hora: " + o.getHoraOcorrencia().format(FORMATADOR_HORA));
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

            String dataStr = scannerPrompt("Data [" + existente.getDiaOcorrencia().format(FORMATADOR_DATA) + "]: ");
            if (!dataStr.isEmpty()) {
                try {
                    LocalDate novaData = LocalDate.parse(dataStr, FORMATADOR_DATA);
                    existente.setDiaOcorrencia(novaData);
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data inválido. Mantendo a data anterior.");
                }
            }

            String horaStr = scannerPrompt("Hora [" + existente.getHoraOcorrencia().format(FORMATADOR_HORA) + "]: ");
            if (!horaStr.isEmpty()) {
                try {
                    LocalTime novaHora = LocalTime.parse(horaStr, FORMATADOR_HORA);
                    existente.setHoraOcorrencia(novaHora);
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de hora inválido. Mantendo a hora anterior.");
                }
            }

            String idAlunoStr = scannerPrompt("ID do Aluno [" + existente.getIdAluno() + "]: ");
            if (!idAlunoStr.isEmpty()) {
                existente.setIdAluno(Integer.parseInt(idAlunoStr));
            }

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
