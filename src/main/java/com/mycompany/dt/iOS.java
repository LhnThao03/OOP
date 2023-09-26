/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dt;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class iOS extends SanPham implements Serializable{
    float phienbanios;
    public iOS(float phienbanios) {
        this.phienbanios = phienbanios;
    }
    @Override
    void xuatBody2() {
        System.out.println(toString());
        System.out.println("Phien ban ios :"+phienbanios);
    }
}
