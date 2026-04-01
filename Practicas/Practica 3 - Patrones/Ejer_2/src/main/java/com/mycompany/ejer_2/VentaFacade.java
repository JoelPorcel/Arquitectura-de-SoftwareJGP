/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_2;

/**
 *
 * @author KUR0
 */
class VentaFacade {
    private Venta ventaActual;

    public void iniciarVenta(String cliente, String fecha, String tipoDoc, String numDoc) {
        ventaActual = new Venta(cliente, fecha, tipoDoc, numDoc);
    }

    public void agregarProductoSimple(String desc, int cant, double precio) {
        ventaActual.agregarDetalle(new ProductoSimple(desc, cant, precio));
    }

    public void finalizarVenta(int opcionPago) {
        ventaActual.mostrarResumen();
        IMetodoPago pago = PagoFactory.getPago(opcionPago);
        pago.procesarPago(ventaActual.getTotal());
        System.out.println("Venta realizada con exito.");
    }
}