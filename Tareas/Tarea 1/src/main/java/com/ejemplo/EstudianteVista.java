package com.ejemplo;

import java.util.List;

public class EstudianteVista {

    public void mostrarEstudianteGuardado(Estudiante estudiante) {
        System.out.println("========================================");
        System.out.println("  ESTUDIANTE GUARDADO EXITOSAMENTE");
        System.out.println("========================================");
        mostrarDetalle(estudiante);
        System.out.println("========================================");
    }

    public void mostrarEstudianteEncontrado(Estudiante estudiante) {
        if (estudiante != null) {
            System.out.println("========================================");
            System.out.println("  ESTUDIANTE ENCONTRADO");
            System.out.println("========================================");
            mostrarDetalle(estudiante);
            System.out.println("========================================");
        } else {
            System.out.println("No se encontro el estudiante.");
        }
    }

    public void mostrarListado(List<Estudiante> estudiantes) {
        System.out.println("=================================================================");
        System.out.println("  LISTADO DE TODOS LOS ESTUDIANTES");
        System.out.println("=================================================================");
        System.out.printf("  %-15s %-20s %-25s %-15s %-5s%n",
                "CI", "NOMBRES", "APELLIDOS", "CELULAR", "SEXO");
        System.out.println("-----------------------------------------------------------------");
        for (Estudiante e : estudiantes) {
            System.out.printf("  %-15s %-20s %-25s %-15s %-5s%n",
                    e.getCi(), e.getNombres(), e.getApellidos(), e.getCelular(), e.getSexo());
        }
        System.out.println("=================================================================");
        System.out.println("  Total de estudiantes: " + estudiantes.size());
        System.out.println("=================================================================");
    }

    public void mostrarEstudianteActualizado(Estudiante estudiante, boolean exito) {
        if (exito) {
            System.out.println("========================================");
            System.out.println("  ESTUDIANTE ACTUALIZADO EXITOSAMENTE");
            System.out.println("========================================");
            mostrarDetalle(estudiante);
            System.out.println("========================================");
        } else {
            System.out.println("No se pudo actualizar el estudiante con CI: " + estudiante.getCi());
        }
    }

    public void mostrarEstudianteEliminado(String ci, boolean exito) {
        if (exito) {
            System.out.println("========================================");
            System.out.println("  ESTUDIANTE ELIMINADO EXITOSAMENTE");
            System.out.println("  CI eliminado: " + ci);
            System.out.println("========================================");
        } else {
            System.out.println("No se encontro ningun estudiante con CI: " + ci);
        }
    }

    public void mostrarMateriasDeEstudiante(Estudiante estudiante, List<Materia> materias) {
        System.out.println("========================================================");
        System.out.println("  MATERIAS DEL ESTUDIANTE: " + estudiante.getNombres()
                + " " + estudiante.getApellidos() + "  [CI: " + estudiante.getCi() + "]");
        System.out.println("========================================================");
        if (materias.isEmpty()) {
            System.out.println("  El estudiante no tiene materias inscritas.");
        } else {
            System.out.printf("  %-12s %-40s%n", "SIGLA", "MATERIA");
            System.out.println("  --------------------------------------------------------");
            for (Materia m : materias) {
                System.out.printf("  %-12s %-40s%n", m.getSigla(), m.getMateria());
            }
            System.out.println("  --------------------------------------------------------");
            System.out.println("  Total: " + materias.size() + " materia(s)");
        }
        System.out.println("========================================================");
    }

    public void mostrarError(String mensaje) {
        System.err.println("ERROR: " + mensaje);
    }

    private void mostrarDetalle(Estudiante estudiante) {
        System.out.println("  CI:        " + estudiante.getCi());
        System.out.println("  Nombres:   " + estudiante.getNombres());
        System.out.println("  Apellidos: " + estudiante.getApellidos());
        System.out.println("  Celular:   " + estudiante.getCelular());
        System.out.println("  Sexo:      " + estudiante.getSexo());
    }
}

