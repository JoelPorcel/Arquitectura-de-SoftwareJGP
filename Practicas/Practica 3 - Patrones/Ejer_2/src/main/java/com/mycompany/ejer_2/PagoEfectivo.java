/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_2;

/**
 *
 * @author KUR0
 */
class PagoEfectivo implements IMetodoPago {
    public void procesarPago(double monto) { 
        System.out.println("Pagando Bs" + monto + " en efectivo."); 
    }
}
