/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author KUR0
 */
public class MamiferoFactory implements AnimalFactory {
    
    @Override
    public Animal crearAnimal(String tipo, String nombre) {
        if (tipo.equals("leon")) return new Leon(nombre, 38.5, 4, "Amarillo");
        if (tipo.equals("oso")) return new Oso(nombre, 37.0, 4, "Café");
        if (tipo.equals("mono")) return new Mono(nombre, 36.5, 2, "Negro");
        return null;
    }
}
