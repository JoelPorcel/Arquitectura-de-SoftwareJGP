/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author KUR0
 */
public class Pacu extends Pez {
    public Pacu(String nombre, double longitud) {
        super(nombre, longitud);
    }

    @Override
    public void nadar() {
        System.out.println("El pacú " + getNombre() + " está nadando en el agua dulce.");
    }
}
