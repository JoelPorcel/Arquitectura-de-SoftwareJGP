/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ejercicio_1;

/**
 *
 * @author KUR0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmailNotification email = new EmailNotification();
        SmsNotification sms = new SmsNotification();
        PushNotification push = new PushNotification();
        PaqueteService paquete1 = new PaqueteService(email);
        paquete1.enviarMensaje("Juan", "no olvidar la tarea");
        PaqueteService paquete2 = new PaqueteService(sms);
        paquete2.enviarMensaje("Juan", "no olvidar la tarea");
        PaqueteService paquete3 = new PaqueteService(push);
        paquete3.enviarMensaje("Juan", "no olvidar la tarea");
    }
    
}
