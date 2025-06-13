package com.Senai.view;

import com.Senai.controller.CursoController;
import com.Senai.model.Curso;
import java.util.Scanner;
import java.util.List;

public class CursoView {
    private static final Scanner scanner = new Scanner(System.in);
    private static CursoController controller = new CursoController();

    public static void main(String[] args) {
        String opcao;
        String menuCurso =
                """
                    --- MENU DE CURSOS ---
                1. Listar cursos
                2. Adicionar curso
                3. Buscar curso por ID
                4. Atualizar curso
                5. Remover curso
                0. Sair
                --> 
                """;

        do {
            System.out.print(menuCurso);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> listar();
                case "2" -> adicionar();
                case "3" -> buscar();
                case "4" -> atualizar();
                case "5" -> remover();
                case "0" -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != "0");
    }

    private static void listar() {
        List<Curso> cursos = controller.listarCursos();
        if (cursos.isEmpty()) {
            System.out.println("Não há cursos cadastrados!");
        } else {
            for (Curso curso : cursos) {
                System.out.println(curso);
            }
        }
    }

    private static void adicionar() {

    }
}
