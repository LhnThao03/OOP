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
public class Android extends SanPham implements Serializable{
     String HangSanXuat;
    public Android(String HangSanXuat) {
        this.HangSanXuat = HangSanXuat;
    }
    @Override
    void xuatBody2() {
         System.out.println(toString());
        System.out.println("HangSanXuat: "+HangSanXuat);
    }
}
