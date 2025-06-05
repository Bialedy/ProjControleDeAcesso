package com.Senai.Justificativa;

import com.Senai.Justificativa.JustificativaController;
import com.Senai.Justificativa.JustificativaView;

public class SistemaJustificativas {
    public static void main(String[] args) {
        JustificativaController controller = new JustificativaController();
        JustificativaView view = new JustificativaView();

        while (true) {
            int opcao = view.exibirMenu();

            switch (opcao) {
                case 1 -> {
                    String nome = view.solicitar("o nome do aluno");
                    String data = view.solicitar("a data do atraso (dd/mm/aaaa)");
                    String motivo = view.solicitar("o motivo");
                    controller.cadastrarJustificativa(nome, data, motivo);
                    view.mostrarMensagem("Justificativa cadastrada com sucesso!\n");
                }
                case 2 -> view.exibirJustificativas(controller.listarJustificativas());
                case 3 -> {
                    int id = view.solicitarId();
                    String nome = view.solicitar("o novo nome do aluno");
                    String data = view.solicitar("a nova data do atraso (dd/mm/aaaa)");
                    String motivo = view.solicitar("o novo motivo");
                    boolean atualizado = controller.atualizarJustificativa(id, nome, data, motivo);
                    view.mostrarMensagem(atualizado ? "Justificativa atualizada com sucesso.\n" : "Justificativa não encontrada.\n");
                }
                case 4 -> {
                    int id = view.solicitarId();
                    boolean removido = controller.removerJustificativa(id);
                    view.mostrarMensagem(removido ? "Justificativa removida com sucesso.\n" : "Justificativa não encontrada.\n");
                }
                case 5 -> {
                    System.out.println("Encerrando o sistema.");
                    return;
                }
                default -> System.out.println("Opção inválida.\n");
            }
        }
    }
}
