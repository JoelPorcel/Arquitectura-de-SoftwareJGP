/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ejercicio_2;

/**
 *
 * @author KUR0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RealFileService file = new RealFileService();
        FileServiceProxy proxy = new FileServiceProxy(file);
        proxy.download("Pedro", "Programacion Java 0 a avanzado");
    }
    
}
