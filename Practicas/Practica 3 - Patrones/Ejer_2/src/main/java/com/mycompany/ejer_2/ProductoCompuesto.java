/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KUR0
 */
class ProductoCompuesto implements IDetalleVenta {
    private String nombreCombo;
    private List<IDetalleVenta> subProductos = new ArrayList<>();

    public ProductoCompuesto(String nombreCombo) {
        this.nombreCombo = nombreCombo;
    }

    public void agregar(IDetalleVenta producto) {
        subProductos.add(producto);
    }

    public String getDescripcion() { return "Combo: " + nombreCombo; }
    public int getCantidad() { return 1; } // Se toma como una unidad de combo
    
    public double getPrecio() {
        return subProductos.stream().mapToDouble(IDetalleVenta::getPrecio).sum();
    }
}