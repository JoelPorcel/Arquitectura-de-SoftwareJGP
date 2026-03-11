/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo;

/**
 *
 * @author KUR0
 */
public class MateriasEst {

    private String ci;
    private String sigla;

    public MateriasEst(String ci, String sigla) {
        this.ci = ci;
        this.sigla = sigla;
    }

    public void setCi(String ci) { this.ci = ci; }
    public void setSigla(String sigla) { this.sigla = sigla; }

    public String getCi() { return ci; }
    public String getSigla() { return sigla; }
}

