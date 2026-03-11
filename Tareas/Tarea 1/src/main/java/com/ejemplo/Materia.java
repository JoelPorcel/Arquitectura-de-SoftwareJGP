/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo;

/**
 *
 * @author KUR0
 */
public class Materia {
    
    private String materia;
    private String sigla;

    public Materia(String materia, String sigla) {
        this.materia = materia;
        this.sigla = sigla;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getMateria() {
        return materia;
    }

    public String getSigla() {
        return sigla;
    }
}
