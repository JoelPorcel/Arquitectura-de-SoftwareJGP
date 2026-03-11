package com.ejemplo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MateriasEstDAO {

    public MateriasEst guardar(MateriasEst materiasEst) throws SQLException {
        String sql = "INSERT INTO materias_estudiante (ci, sigla) VALUES (?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, materiasEst.getCi());
            ps.setString(2, materiasEst.getSigla());

            ps.executeUpdate();
        }

        return materiasEst;
    }

    public MateriasEst buscarPorSiglaCi(String sigla, String ci) throws SQLException {
        String sql = "SELECT ci, sigla FROM materias_estudiante WHERE sigla = ? AND ci = ?";
        MateriasEst materiasEst = null;

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sigla);
            ps.setString(2, ci);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materiasEst = new MateriasEst(
                    rs.getString("ci"),
                    rs.getString("sigla")
                );
            }
        }

        return materiasEst;
    }

    public List<MateriasEst> listarTodos() throws SQLException {
        String sql = "SELECT ci, sigla FROM materias_estudiante";
        List<MateriasEst> materiasEsts = new ArrayList<>();

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                MateriasEst materiasEst = new MateriasEst(
                    rs.getString("ci"),
                    rs.getString("sigla")
                );
                materiasEsts.add(materiasEst);
            }
        }

        return materiasEsts;
    }

    public boolean actualizarSigla(MateriasEst materiasEst) throws SQLException {
        String sql = "UPDATE materias_estudiante SET sigla=? WHERE sigla = ? AND ci = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, materiasEst.getSigla());
            ps.setString(2, materiasEst.getSigla());
            ps.setString(3, materiasEst.getCi());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Materia> listarMateriasPorEstudiante(String ci) throws SQLException {
        String sql = "SELECT m.sigla, m.materia FROM materia m "
                   + "INNER JOIN materias_estudiante me ON m.sigla = me.sigla "
                   + "WHERE me.ci = ?";
        List<Materia> materias = new ArrayList<>();

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ci);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                materias.add(new Materia(
                    rs.getString("materia"),
                    rs.getString("sigla")
                ));
            }
        }

        return materias;
    }

    public boolean eliminar(String ci, String sigla) throws SQLException {
        String sql = "DELETE FROM materias_estudiante WHERE sigla = ? and ci = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sigla);
            ps.setString(2, ci);
            return ps.executeUpdate() > 0;
        }
    }
}
