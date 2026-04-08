/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio_2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author KUR0
 */
public class FileServiceProxy implements IFileService{
    
    IFileService file;

    public FileServiceProxy(IFileService file) {
        this.file = file;
    }
    
    public Boolean permiso(String usuario){
        if("Juan".equals(usuario) || "Pedro".equals(usuario) || "Benghi".equals(usuario)) {
            System.out.println("Tiene permiso para descargar el archivo");
            return true;
        }else {
            System.out.println("No tiene permiso para descargar el archivo");
            return false;
        }
    }
    
    @Override
    public void download(String usuario, String archivo) {
        if(permiso(usuario)) {
            Date date = new Date();
            System.out.println("Se descargara el archivo " + archivo + " con registro en fecha: " + date);
            file.download(usuario, archivo);
        }
    }
    
}
