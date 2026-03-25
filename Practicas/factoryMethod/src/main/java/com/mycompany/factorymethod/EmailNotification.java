/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.factorymethod;

/**
 *
 * @author KUR0
 */
public class EmailNotification implements INotification {
    @Override
    public void notifyUser(String message) {
        System.out.println("[CONECTANDO AL SERVIDOR...]");
        System.out.println("Enviando Email: " + message);
        System.out.println("Estado: Entregado exitosamente.");
    }
}
