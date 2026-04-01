/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_3;

/**
 *
 * @author KUR0
 */
public class LibroReal implements Libro{
    String texto;
    String titulo;
    String autor;
    int anio;

    public LibroReal(String texto, String titulo, String autor, int anio) {
        this.texto = texto;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    @Override
    public void leer() {
        System.out.println("Titulo:" + getTitulo());
        System.out.println("Autor:" + getAutor());
        System.out.println("Texto:" + getTexto());
        System.out.println("Anio:" + getAnio());
        
    }

    public String getTexto() {
        return texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
}
