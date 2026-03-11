package com.ejemplo;

import java.util.ArrayList;


public class Estudiante {

    private String ci;
    private String nombres;
    private String apellidos;
    private String celular;
    private String sexo;

    public Estudiante(String ci, String nombres, String apellidos, String celular, String sexo) {
        this.ci = ci;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.sexo = sexo;
    }
    ArrayList <String> materias = new ArrayList();

    public Estudiante() {
    }

    public String getCi() {
        return ci;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public String getSexo() {
        return sexo;
    }

    public ArrayList<String> getMaterias() {
        return materias;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setMaterias(ArrayList<String> materias) {
        this.materias = materias;
    }

 
}
