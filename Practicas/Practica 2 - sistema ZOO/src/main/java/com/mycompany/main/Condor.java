/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author KUR0
 */
public class Condor extends Ave {
    public Condor(String nombre, double peso, double tamanoAlas) {
        super(nombre, peso, tamanoAlas);
    }

    @Override
    public void volar() {
        System.out.println("El cóndor " + getNombre() + " está planeando sobre las montañas.");
    }
}