/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.factorymethod;

/**
 *
 * @author KUR0
 */
public class SMSNotification implements INotification {
    @Override
    public void notifyUser(String message) {
        System.out.println("[CONECTANDO A LA RED MOVIL]");
        System.out.println("Enviando SMS: " + message);
        System.out.println("Estado: Mensaje de texto enviado.");
        System.out.println("--------------------------------------------------");
    }
}
