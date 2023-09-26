package com.mycompany.dt;
import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;
public class ChiTietPhieuNhap implements Serializable{
    private String MaSP;
    private Integer soLuong;
    private Float donGia;
    private double thanhTien;
    transient Scanner sc = new Scanner(System.in);
    public ChiTietPhieuNhap(String MaSP) {
        this.MaSP = MaSP;
    }

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(String MaSP, Integer soLuong, Float donGia, double thanhTien) {
        this.MaSP = MaSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChiTietPhieuNhap other = (ChiTietPhieuNhap) obj;
        return Objects.equals(this.MaSP, other.MaSP);
    }
    
    void Nhap(){
        System.out.print("So luong: ");
        this.soLuong = sc.nextInt();
        System.out.print("Don gia: ");
        this.donGia = sc.nextFloat();
        thanhTien = soLuong*donGia;
    }

    @Override
    public String toString() {
        return  " MaSP: " + MaSP + "| So luong: " + soLuong + "| Don gia:" + donGia + "| Thanh tien: " + thanhTien;
             
    }
}
