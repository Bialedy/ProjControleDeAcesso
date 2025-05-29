package com.Senai.Justificativa;

    import java.sql.*;
import java.util.*;

    public class JustificativaDAOMySQL {
        private final String url = "jdbc:mysql://localhost:3306/sistema_justificativas";
        private final String user = "root";
        private final String password = "sua_senha";

        public void adicionar(Justificativa j) {
            String sql = "INSERT INTO justificativas (nome, data, motivo) VALUES (?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, j.getNome());
                stmt.setString(2, j.getData());
                stmt.setString(3, j.getMotivo());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public List<Justificativa> listar() {
            List<Justificativa> lista = new ArrayList<>();
            String sql = "SELECT * FROM justificativas";
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    lista.add(new Justificativa(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("data"),
                            rs.getString("motivo")
                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return lista;
        }

        public boolean remover(int id) {
            String sql = "DELETE FROM justificativas WHERE id = ?";
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                return stmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean atualizar(Justificativa j) {
            String sql = "UPDATE justificativas SET nome = ?, data = ?, motivo = ? WHERE id = ?";
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, j.getNome());
                stmt.setString(2, j.getData());
                stmt.setString(3, j.getMotivo());
                stmt.setInt(4, j.getId());
                return stmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        public Justificativa buscarPorId(int id) {
            String sql = "SELECT * FROM justificativas WHERE id = ?";
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return new Justificativa(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("data"),
                            rs.getString("motivo")
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

