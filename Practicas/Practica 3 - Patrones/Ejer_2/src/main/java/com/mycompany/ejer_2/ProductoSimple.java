/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_2;

/**
 *
 * @author KUR0
 */
class ProductoSimple implements IDetalleVenta {
    private String descripcion;
    private int cantidad;
    private double precioUnitario;

    public ProductoSimple(String descripcion, int cantidad, double precioUnitario) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
    
    @Override
    public double getPrecio() { 
        return precioUnitario * cantidad; 
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

}
