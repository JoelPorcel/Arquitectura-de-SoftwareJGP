/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.factorymethod;

/**
 *
 * @author KUR0
 */
public abstract class NotificationFactory {
    
    protected abstract INotification createNotification();

    public void sendAlert(String message) {

        INotification notification = createNotification();
        
        notification.notifyUser(message);
    }
}
