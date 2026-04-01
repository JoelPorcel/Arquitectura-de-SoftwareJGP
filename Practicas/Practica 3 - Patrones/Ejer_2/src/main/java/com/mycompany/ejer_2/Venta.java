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
class Venta {
    private String nombreCliente;
    private String fecha;
    private String tipoDoc;
    private String numDoc;
    private List<IDetalleVenta> detalles = new ArrayList<>();

    public Venta(String nombre, String fecha, String tipoDoc, String numDoc) {
        this.nombreCliente = nombre;
        this.fecha = fecha;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
    }

    public void agregarDetalle(IDetalleVenta detalle) { detalles.add(detalle); }

    public void mostrarResumen() {
        System.out.println("\n DETALLE DE VENTA");
        double total = 0;
        for (IDetalleVenta d : detalles) {
            System.out.println(d.getDescripcion() + " x" + d.getCantidad() + " - Subtotal: Bs" + d.getPrecio());
            total += d.getPrecio();
        }
        System.out.println("TOTAL A COBRAR: Bs" + total);
    }

    public double getTotal() {
        return detalles.stream().mapToDouble(IDetalleVenta::getPrecio).sum();
    }
}
