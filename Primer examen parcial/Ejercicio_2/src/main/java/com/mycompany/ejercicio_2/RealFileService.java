/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio_2;

/**
 *
 * @author KUR0
 */
public class RealFileService implements IFileService{
    
    @Override
    public void download(String usuario, String archivo) {
        System.out.println("Descargando archivo con el usuario "+ usuario);
    }
    
}
