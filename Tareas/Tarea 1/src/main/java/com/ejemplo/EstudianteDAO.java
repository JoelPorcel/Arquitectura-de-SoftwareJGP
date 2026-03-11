package com.ejemplo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EstudianteDAO {

    public Estudiante guardar(Estudiante estudiante) throws SQLException {
        String sql = "INSERT INTO estudiante (ci, nombres, apellidos, celular, sexo) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, estudiante.getCi());
            ps.setString(2, estudiante.getNombres());
            ps.setString(3, estudiante.getApellidos());
            ps.setString(4, estudiante.getCelular());
            ps.setString(5, estudiante.getSexo());
            
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                estudiante.setCi(estudiante.getCi());
            }
        }

        return estudiante;
    }

    public Estudiante buscarPorCi(String ci) throws SQLException {
        String sql = "SELECT ci, nombres, apellidos, celular, sexo FROM estudiante WHERE ci = ?";
        Estudiante estudiante = null;

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ci);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                estudiante = new Estudiante(
                    rs.getString("ci"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("celular"),
                    rs.getString("sexo")
                );
            }
        }

        return estudiante;
    }

    public List<Estudiante> listarTodos() throws SQLException {
        String sql = "SELECT ci, nombres, apellidos, celular, sexo FROM estudiante";
        List<Estudiante> estudiantes = new ArrayList<>();

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Estudiante estudiante = new Estudiante(
                    rs.getString("ci"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("celular"),
                    rs.getString("sexo")
                );
                estudiantes.add(estudiante);
            }
        }

        return estudiantes;
    }

    public boolean actualizar(Estudiante estudiante) throws SQLException {
        String sql = "UPDATE estudiante SET nombres = ?, apellidos = ?, celular = ?, sexo = ? WHERE ci = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, estudiante.getNombres());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getCelular());
            ps.setString(4, estudiante.getSexo());
            ps.setString(5, estudiante.getCi());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean eliminar(String ci) throws SQLException {
        String sql = "DELETE FROM estudiante WHERE ci = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ci);
            return ps.executeUpdate() > 0;
        }
    }
}
