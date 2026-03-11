package com.ejemplo;

import java.util.List;


public class MateriaVista {

    public void mostrarMateriaGuardada(Materia materia) {
        System.out.println("========================================");
        System.out.println("  MATERIA GUARDADA EXITOSAMENTE");
        System.out.println("========================================");
        mostrarDetalle(materia);
        System.out.println("========================================");
    }

    public void mostrarMateriaEncontrada(Materia materia) {
        if (materia != null) {
            System.out.println("========================================");
            System.out.println("  MATERIA ENCONTRADA");
            System.out.println("========================================");
            mostrarDetalle(materia);
            System.out.println("========================================");
        } else {
            System.out.println("No se encontro la materia.");
        }
    }

    public void mostrarListado(List<Materia> materias) {
        System.out.println("========================================================");
        System.out.println("  LISTADO DE TODAS LAS MATERIAS");
        System.out.println("========================================================");
        System.out.printf("  %-12s %-40s%n", "SIGLA", "MATERIA");
        System.out.println("--------------------------------------------------------");
        for (Materia m : materias) {
            System.out.printf("  %-12s %-40s%n", m.getSigla(), m.getMateria());
        }
        System.out.println("========================================================");
        System.out.println("  Total de materias: " + materias.size());
        System.out.println("========================================================");
    }

    public void mostrarMateriaActualizada(Materia materia, boolean exito) {
        if (exito) {
            System.out.println("========================================");
            System.out.println("  MATERIA ACTUALIZADA EXITOSAMENTE");
            System.out.println("========================================");
            mostrarDetalle(materia);
            System.out.println("========================================");
        } else {
            System.out.println("No se pudo actualizar la materia con sigla: " + materia.getSigla());
        }
    }

    public void mostrarMateriaEliminada(String sigla, boolean exito) {
        if (exito) {
            System.out.println("========================================");
            System.out.println("  MATERIA ELIMINADA EXITOSAMENTE");
            System.out.println("  Sigla eliminada: " + sigla);
            System.out.println("========================================");
        } else {
            System.out.println("No se encontro ninguna materia con sigla: " + sigla);
        }
    }

    public void mostrarError(String mensaje) {
        System.err.println("ERROR: " + mensaje);
    }

    private void mostrarDetalle(Materia materia) {
        System.out.println("  Sigla:   " + materia.getSigla());
        System.out.println("  Materia: " + materia.getMateria());
    }
}

