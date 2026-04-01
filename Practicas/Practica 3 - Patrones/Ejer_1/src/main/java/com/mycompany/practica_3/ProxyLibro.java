/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_3;

/**
 *
 * @author KUR0
 */
public class ProxyLibro implements Libro{
    Libro libro;

    public ProxyLibro(LibroReal libro) {
        this.libro = libro;
    }
    

    public boolean controlAcceso(){
        System.out.println("Tiene acceso pibe");
        return true;
    } 
    @Override
    public void leer() {
        if(controlAcceso()){
            libro.leer();
        }
    }
    
}
