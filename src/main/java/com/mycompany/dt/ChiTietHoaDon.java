package com.mycompany.dt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ChiTietHoaDon {

    private String tenSanPham, MaSP;
    private int soLuong,conLai, donGia,tongTien;
    public ChiTietHoaDon(){
        this.tenSanPham = "";
        this.soLuong = 0;
        this.donGia = 0;
        this.conLai = 0;
        this.tongTien = 0;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getConlai() {
        return conLai;
    }

    public void setConLai(int conLai) {
        this.conLai = conLai;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public void XuatHeaderCTHD(){
        // hd.docFile();
        // System.out.printf("%7s | ",hd.getMaHoaDon());
        System.out.printf("%7s | ",getTenSanPham());
        System.out.printf("%13s |",getSoLuong());
        System.out.printf("%14d |",getDonGia());
        System.out.printf("%7d",getConlai());
    }

    public void XuatBodyCTHD1(){
        // hd.docFile();
        System.out.printf("%5s | ",getMaSP());
        System.out.printf("%5s | ",getTenSanPham());
        System.out.printf("%13s |",getSoLuong());
        System.out.printf("%14d |",getDonGia());
        System.out.printf("%7d |",getConlai());
        System.out.printf("%7d\n",getTongTien());
    }

  
}
