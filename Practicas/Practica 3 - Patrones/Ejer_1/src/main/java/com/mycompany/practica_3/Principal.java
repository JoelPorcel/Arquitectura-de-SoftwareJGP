/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.practica_3;

/**
 *
 * @author KUR0
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LibroReal libro = new LibroReal("Como la IA se revelo", "No tengo boca y debo gritar", "Harlan Ellison", 1967);
        ProxyLibro proxy = new ProxyLibro(libro);
        proxy.leer();
    }
    
}
