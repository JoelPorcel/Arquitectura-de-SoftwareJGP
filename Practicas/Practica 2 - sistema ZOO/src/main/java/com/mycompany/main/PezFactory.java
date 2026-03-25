/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author KUR0
 */
public class PezFactory implements AnimalFactory {
    @Override
    public Animal crearAnimal(String tipo, String nombre) {
        if (tipo.equals("pacu")) return new Pacu(nombre, 45.0);
        if (tipo.equals("sabalo")) return new Sabalo(nombre, 60.0);
        return null;
    }
}