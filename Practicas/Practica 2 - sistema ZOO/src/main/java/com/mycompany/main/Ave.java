/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author KUR0
 */
public abstract class Ave extends Animal {
    protected double peso;
    protected double tamanoAlas;

    public Ave(String nombre, double peso, double tamanoAlas) {
        super(nombre);
        this.peso = peso;
        this.tamanoAlas = tamanoAlas;
    }

    public abstract void volar();

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTamanoAlas() {
        return tamanoAlas;
    }

    public void setTamanoAlas(double tamanoAlas) {
        this.tamanoAlas = tamanoAlas;
    }

    @Override
    public String toString() {
        return super.toString() + " | Ave [Peso: " + peso + "kg, Tamaño alas: " + tamanoAlas + "m]";
    }
}