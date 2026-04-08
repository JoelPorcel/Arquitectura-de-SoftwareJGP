/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio_1;

/**
 *
 * @author KUR0
 */
public class SmsNotification implements INotificationService {

    @Override
    public void send(String destinatario, String mensaje) {
        System.out.println("Mensaje SMS \n De: " + destinatario +"\n Mensaje: " + mensaje);
    }
    
    
}
