/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author KUR0
 */
import java.util.ArrayList;

public class Zoologico {
    private String nombre;
    private String direccion;
    private String telefono;
    private ArrayList<Jaula> listaJaulas;

    public Zoologico(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaJaulas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public ArrayList<Jaula> getListaJaulas() {
        return listaJaulas;
    }

    public void setListaJaulas(ArrayList<Jaula> listaJaulas) {
        this.listaJaulas = listaJaulas;
    }
    @Override
    public String toString() {
        return "Zoologico: " + nombre + "\nDireccion: " + direccion + "\nTelefono: " + telefono + "\nJaulas ocupadas: " + listaJaulas.size();
    }
}
