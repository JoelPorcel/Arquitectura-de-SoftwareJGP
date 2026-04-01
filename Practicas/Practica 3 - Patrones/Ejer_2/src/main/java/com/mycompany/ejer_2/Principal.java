/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ejer_2;

import java.util.Scanner;

/**
 *
 * @author KUR0
 */
public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VentaFacade facade = new VentaFacade();

        System.out.println("Iniciando nueva venta...");
        facade.iniciarVenta("Juan Perez", "31/03/2026", "NIT", "1234567");

        facade.agregarProductoSimple("Leche", 2, 1.50);
        facade.agregarProductoSimple("Pan", 10, 0.50);

        ProductoCompuesto comboDesayuno = new ProductoCompuesto("Pack Desayuno");
        comboDesayuno.agregar(new ProductoSimple("Café", 1, 3.00));
        comboDesayuno.agregar(new ProductoSimple("Galletas", 1, 2.00));
        
        System.out.println("Seleccione tipo de pago: 1.Efectivo, 2.Tarjeta, 3.Transferencia");
        int pagoOpc = sc.nextInt();

        facade.finalizarVenta(pagoOpc);
    }
    
}
