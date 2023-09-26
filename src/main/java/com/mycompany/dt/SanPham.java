package com.mycompany.dt;

import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;


public  abstract class SanPham implements Comparable<SanPham>, Serializable {

    private String maSanPham, tenSanPham;
    private int soLuong;
    private float donGia;
   private  int NamSX;
    private ChiTietSanPham chitietSP = new ChiTietSanPham();
   transient Scanner sc = new Scanner(System.in);

    public SanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public SanPham(String maSanPham, String tenSanPham, float donGia, int soLuong) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }
    
    public SanPham() {
        this.maSanPham = "";
        this.tenSanPham = "";
        this.donGia = 0;
        this.soLuong = 0;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
            this.maSanPham=maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public int getNamSX() {
        return NamSX;
    }

    public void setNamSX(int NamSX) {
        this.NamSX = NamSX;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public ChiTietSanPham getChitietSP() {
        return chitietSP;
    }

    public void setChitietSP(ChiTietSanPham chitietSP) {
        this.chitietSP = chitietSP;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    void nhap(){
        System.out.print("Ten san pham: ");
        this.tenSanPham = sc.nextLine();
        System.out.print("Don gia: ");
        this.donGia = sc.nextFloat();
        System.out.print("So luong: ");
        this.soLuong = sc.nextInt();
        System.out.print("Nam san xuat: ");
        this.NamSX = sc.nextInt();
         sc.nextLine();
         chitietSP.nhap();
    }
    abstract void xuatBody2();
    @Override
    public int compareTo(SanPham o) {
        return this.maSanPham.compareTo(o.maSanPham);
    }

    @Override
    public String toString() {
        return "Ma san pham: " + maSanPham + "| TenSanPham: " + tenSanPham + "| So luong: " + soLuong + "| Don gia: " + donGia + "\n"+ chitietSP;
    }
}