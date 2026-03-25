/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author KUR0
 */
public abstract class Pez extends Animal {
    protected double longitud;

    public Pez(String nombre, double longitud) {
        super(nombre);
        this.longitud = longitud;
    }

    public abstract void nadar();

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return super.toString() + " | Pez [Longitud: " + longitud + "cm]";
    }
}