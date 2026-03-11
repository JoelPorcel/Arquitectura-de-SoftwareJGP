package com.ejemplo;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("=====================================================");
        System.out.println(" EJEMPLO: Aplicacion CORRECTA del Principio SRP");
        System.out.println(" Cada clase tiene UNA SOLA responsabilidad");
        System.out.println("=====================================================\n");

        EstudianteDAO estudianteDAO   = new EstudianteDAO();
        EstudianteVista estudianteVista = new EstudianteVista();
        MateriaDAO materiaDAO         = new MateriaDAO();
        MateriaVista materiaVista     = new MateriaVista();
        MateriaEstDAO mEstDAO         = new MateriaEstDAO();

        try {

            System.out.println(">>> 1. CREAR estudiantes\n");

            Estudiante est1 = new Estudiante("12345678", "Juan", "Perez Lopez", "70000001", "M");
            est1 = estudianteDAO.guardar(est1);
            estudianteVista.mostrarEstudianteGuardado(est1);

            Estudiante est2 = new Estudiante("87654321", "Maria", "Gomez Ruiz", "70000002", "F");
            est2 = estudianteDAO.guardar(est2);
            estudianteVista.mostrarEstudianteGuardado(est2);

            System.out.println("\n>>> 2. LEER estudiante por CI\n");
            Estudiante encontrado = estudianteDAO.buscarPorCi("12345678");
            estudianteVista.mostrarEstudianteEncontrado(encontrado);

            System.out.println("\n>>> 3. LISTAR todos los estudiantes\n");
            List<Estudiante> todosEst = estudianteDAO.listarTodos();
            estudianteVista.mostrarListado(todosEst);

            System.out.println("\n>>> 4. ACTUALIZAR un estudiante\n");
            if (encontrado != null) {
                encontrado.setCelular("70000099");
                boolean actualizado = estudianteDAO.actualizar(encontrado);
                estudianteVista.mostrarEstudianteActualizado(encontrado, actualizado);
            }

            System.out.println("\n>>> 5. ELIMINAR un estudiante\n");
            boolean eliminadoEst = estudianteDAO.eliminar("87654321");
            estudianteVista.mostrarEstudianteEliminado("87654321", eliminadoEst);

            System.out.println("\n>>> 6. LISTAR estudiantes despues de cambios\n");
            estudianteVista.mostrarListado(estudianteDAO.listarTodos());

            System.out.println("\n>>> 7. CREAR materias\n");

            Materia mat1 = new Materia("Base de datos 1", "SIS302");
            mat1 = materiaDAO.guardar(mat1);
            materiaVista.mostrarMateriaGuardada(mat1);

            Materia mat2 = new Materia("Base de datos 2", "SIS304");
            mat2 = materiaDAO.guardar(mat2);
            materiaVista.mostrarMateriaGuardada(mat2);

            Materia mat3 = new Materia("Arquitectura de software", "COM350");
            mat3 = materiaDAO.guardar(mat3);
            materiaVista.mostrarMateriaGuardada(mat3);

            Materia mat4 = new Materia("Inteligencia Artificial 2", "SIS421");
            mat4 = materiaDAO.guardar(mat4);
            materiaVista.mostrarMateriaGuardada(mat4);

            System.out.println("\n>>> 8. LEER materia por sigla\n");
            Materia encontradaMat = materiaDAO.buscarPorSigla("SIS302");
            materiaVista.mostrarMateriaEncontrada(encontradaMat);

            System.out.println("\n>>> 9. LISTAR todas las materias\n");
            List<Materia> todasMat = materiaDAO.listarTodos();
            materiaVista.mostrarListado(todasMat);

            System.out.println("\n>>> 10. ACTUALIZAR una materia\n");
            if (encontradaMat != null) {
                encontradaMat.setMateria("Base de datos I (actualizada)");
                boolean actualizadaMat = materiaDAO.actualizar(encontradaMat);
                materiaVista.mostrarMateriaActualizada(encontradaMat, actualizadaMat);
            }

            System.out.println("\n>>> 11. ELIMINAR una materia\n");
            boolean eliminadaMat = materiaDAO.eliminar("SIS304");
            materiaVista.mostrarMateriaEliminada("SIS304", eliminadaMat);

            System.out.println("\n>>> 12. LISTAR materias despues de cambios\n");
            List<Materia> materiasActuales = materiaDAO.listarTodos();
            materiaVista.mostrarListado(materiasActuales);

            // -------------------------------------------------------
            // Ni bien hay un estudiante y materias: INSCRIBIR EN TODO
            // -------------------------------------------------------
            System.out.println("\n>>> 13. INSCRIBIR estudiante en TODAS las materias disponibles\n");
            mEstDAO.inscribirEnTodasLasMaterias(est1.getCi(), materiasActuales);
            System.out.println("  Estudiante " + est1.getCi()
                + " inscrito automaticamente en " + materiasActuales.size() + " materia(s).");

            System.out.println("\n>>> 14. LISTAR materias del estudiante " + est1.getCi() + "\n");
            List<Materia> materiasDeEst = mEstDAO.listarMateriasPorEstudiante(est1.getCi());
            estudianteVista.mostrarMateriasDeEstudiante(est1, materiasDeEst);

            System.out.println("\n>>> 15. LISTAR todas las inscripciones\n");
            List<MateriasEst> inscripciones = mEstDAO.listarTodos();
            System.out.printf("  %-15s %-12s%n", "CI", "SIGLA");
            System.out.println("  ---------------------------");
            for (MateriasEst me : inscripciones) {
                System.out.printf("  %-15s %-12s%n", me.getCi(), me.getSigla());
            }

            System.out.println("\n>>> 16. ELIMINAR una inscripcion\n");
            boolean eliminadaInsc = mEstDAO.eliminar(est1.getCi(), "COM350");
            System.out.println(eliminadaInsc
                    ? "  Inscripcion eliminada exitosamente."
                    : "  No se encontro la inscripcion.");


        } catch (SQLException e) {
            estudianteVista.mostrarError(e.getMessage());
        }
    }
}

