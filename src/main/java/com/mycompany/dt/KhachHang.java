package com.mycompany.dt;
import java.io.Serializable;
import java.util.Scanner;
public class KhachHang implements Serializable{
    String MaKH, TenKH, DiaChi, SDT;
    transient Scanner sc = new Scanner(System.in);
    public KhachHang() {
    }

    public KhachHang(String MaKH, String TenKH, String DiaChi, String SDT) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    void nhap(){
        System.out.print("Ten khach hang: ");
        this.TenKH = sc.nextLine();
        System.out.print("Dia chi cua khach hang: ");
        this.DiaChi = sc.nextLine();
        System.out.print("So dien thoai cua khach hang");
        this.SDT = sc.nextLine();
    }

    @Override
    public String toString() {
        return   " MaKH: " + MaKH + ", TenKH: " + TenKH + ", DiaChi: " + DiaChi + ", SDT: " + SDT;
    }
    
}
