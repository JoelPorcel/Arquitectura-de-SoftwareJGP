/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_2;

/**
 *
 * @author KUR0
 */
class PagoFactory {
public static IMetodoPago getPago(int opcion) {
    IMetodoPago metodoPago = null;

    switch (opcion) {
        case 1:
            metodoPago = new PagoEfectivo();
            break;

        case 2:
            metodoPago = new PagoTarjeta();
            break;

        case 3:
            metodoPago = new PagoTransferencia();
            break;

        default:
            System.out.println("Opcion no valida");
    }
    return metodoPago;
}
}
