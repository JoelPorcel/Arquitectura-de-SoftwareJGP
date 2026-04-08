/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio_1;

/**
 *
 * @author KUR0
 */
public class PaqueteService {
    INotificationService noti;

    public PaqueteService(INotificationService noti) {
        this.noti = noti;
    }
    
    public void enviarMensaje(String destinatario, String mensaje) {
        noti.send(destinatario, mensaje);
    }
    
    
    
    
}
