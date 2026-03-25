/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.factorymethod;

/**
 *
 * @author KUR0
 */
public class FactoryMethod {

    public static void processAlerts(NotificationFactory factory, String message) {
        factory.sendAlert(message);
    }

    public static void main(String[] args) {
        System.out.println("INICIANDO SISTEMA DE ALERTAS\n");

        NotificationFactory emailCreator = new EmailCreator();
        processAlerts(emailCreator, "Bienvenido a nuestra plataforma (Via Email).");

        NotificationFactory smsCreator = new SMSCreator();
        processAlerts(smsCreator, "Tu codigo de verificacion es 8493 (Via SMS).");
    }
}
