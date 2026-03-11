package com.ejemplo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MateriaDAO {

    public Materia guardar(Materia materia) throws SQLException {
        String sql = "INSERT INTO materia (sigla, materia) VALUES (?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, materia.getSigla());
            ps.setString(2, materia.getMateria());
            
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setSigla(materia.getSigla());
            }
        }

        return materia;
    }

    public Materia buscarPorSigla(String sigla) throws SQLException {
        String sql = "SELECT sigla, materia FROM materia WHERE sigla = ?";
        Materia materia = null;

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia(
                    rs.getString("materia"),
                    rs.getString("sigla")
                );
            }
        }

        return materia;
    }

    public List<Materia> listarTodos() throws SQLException {
        String sql = "SELECT sigla, materia FROM materia";
        List<Materia> materias = new ArrayList<>();

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Materia materia = new Materia(
                    rs.getString("materia"),
                    rs.getString("sigla")
                );
                materias.add(materia);
            }
        }

        return materias;
    }

    public boolean actualizar(Materia materia) throws SQLException {
        String sql = "UPDATE materia SET materia=? WHERE sigla = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, materia.getMateria());
            ps.setString(2, materia.getSigla());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean eliminar(String sigla) throws SQLException {
        String sql = "DELETE FROM materia WHERE sigla = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sigla);
            return ps.executeUpdate() > 0;
        }
    }
}
