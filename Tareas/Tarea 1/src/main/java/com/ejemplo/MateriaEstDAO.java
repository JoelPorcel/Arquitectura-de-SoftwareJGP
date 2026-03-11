package com.ejemplo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MateriaEstDAO {

    /**
     * Inscribe a un estudiante en una materia.
     */
    public MateriasEst inscribir(MateriasEst me) throws SQLException {
        String sql = "INSERT INTO materias_estudiante (ci, sigla) VALUES (?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, me.getCi());
            ps.setString(2, me.getSigla());
            ps.executeUpdate();
        }

        return me;
    }

    /**
     * Inscribe automaticamente a un estudiante en TODAS las materias de la lista.
     * Usa batch para hacer todo en una sola conexion.
     */
    public void inscribirEnTodasLasMaterias(String ci, List<Materia> materias)
            throws SQLException {
        String sql = "INSERT INTO materias_estudiante (ci, sigla) VALUES (?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (Materia m : materias) {
                ps.setString(1, ci);
                ps.setString(2, m.getSigla());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    /**
     * Busca una inscripcion por CI del estudiante y sigla de la materia.
     */
    public MateriasEst buscarPorCiYSigla(String ci, String sigla) throws SQLException {
        String sql = "SELECT ci, sigla FROM materias_estudiante WHERE ci = ? AND sigla = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ci);
            ps.setString(2, sigla);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new MateriasEst(
                    rs.getString("ci"),
                    rs.getString("sigla")
                );
            }
        }

        return null;
    }

    /**
     * Lista todas las materias en las que esta inscrito un estudiante (JOIN con materia).
     */
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

    /**
     * Lista todas las inscripciones registradas en la BD.
     */
    public List<MateriasEst> listarTodos() throws SQLException {
        String sql = "SELECT ci, sigla FROM materias_estudiante";
        List<MateriasEst> lista = new ArrayList<>();

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new MateriasEst(
                    rs.getString("ci"),
                    rs.getString("sigla")
                ));
            }
        }

        return lista;
    }

    /**
     * Elimina una inscripcion especifica por CI y sigla.
     */
    public boolean eliminar(String ci, String sigla) throws SQLException {
        String sql = "DELETE FROM materias_estudiante WHERE ci = ? AND sigla = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ci);
            ps.setString(2, sigla);
            return ps.executeUpdate() > 0;
        }
    }

}
