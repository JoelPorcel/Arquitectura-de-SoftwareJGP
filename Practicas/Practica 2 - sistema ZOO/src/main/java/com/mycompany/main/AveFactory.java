/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author KUR0
 */
public class AveFactory implements AnimalFactory {
    @Override
    public Animal crearAnimal(String tipo, String nombre) {
        if (tipo.equals("loro")) return new Loro(nombre, 1.2, 0.4);
        if (tipo.equals("aguila")) return new Aguila(nombre, 5.0, 2.2);
        if (tipo.equals("condor")) return new Condor(nombre, 11.0, 3.0);
        return null;
    }
}
