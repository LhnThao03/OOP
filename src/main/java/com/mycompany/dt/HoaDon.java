package com.mycompany.dt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class HoaDon implements Comparable<HoaDon>, Serializable {

    private String maHoaDon, maNhanVien, maKhachHang, gioLap;
    private int tongTien = 0;
    SanPham[] sanPham = new SanPham[50];
    int k =0;
    public HoaDon() {
        this.maHoaDon = "";
        this.maNhanVien = "";
        this.maKhachHang = "";
        this.gioLap = "";
        this.tongTien = 0;
    }

    public HoaDon(String maHoaDon, String maNhanVien, String maKhachHang, String ngayNhap, String gioLap, int tongTien) {
        this.maHoaDon = maHoaDon;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.gioLap = gioLap;
        this.tongTien = tongTien;
    }

    public HoaDon(String maHoaDon, String maNhanVien, String maKhachHang, String gioLap) {
        this.maHoaDon = maHoaDon;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.gioLap = gioLap;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getGioLap() {
        return gioLap;
    }

    public void setGioLap(String gioLap) {
        this.gioLap = gioLap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int TongTien) {
        this.tongTien = TongTien;
    }
    void nhap(){
        Scanner sc = new Scanner(System.in);
        String MaSP;
    DanhSachSanPham a = new DanhSachSanPham();
    String c = "N";
        System.out.print("Ban muon ban san pham nao vui long nhap ma: ");
        MaSP = sc.nextLine();
        while(a.checkMASP(MaSP)== null){
            System.out.print("Ma khong ton tai trong danh sach(Ban co muon xem danh sach san pham Y/phimbatky): ");
            c = sc.nextLine();
            if(c.equals("Y")){
            a.xuat();
            }
            System.out.print("Vui long nhap lai ma san pham: ");
            MaSP = sc.nextLine();
        }
        if(a.checkMASP(MaSP).getSoLuong()==0){
            System.out.println("Khong co san pham de mua");
        return;
        }
        sanPham[k] = a.checkMASP(MaSP);
        System.out.print("San pham da chon con lai so luong " + sanPham[k].getSoLuong()+" ban muon lay bao nhieu: ");
        int soluong = sc.nextInt();
        while(soluong>sanPham[k].getSoLuong()){
            System.out.print("Vui long nhap lai so luong vi ko du nhu cau: ");
            soluong = sc.nextInt();
        }
        sanPham[k].setSoLuong(sanPham[k].getSoLuong()-soluong);
        a.ghifile();
        k++;
}
    void ChonSP(String loai){
        Scanner sc = new Scanner(System.in);
        String MaSP;
    DanhSachSanPham a = new DanhSachSanPham();
    String c = "N";
        System.out.print("Ban muon ban san pham nao vui long nhap ma: ");
        MaSP = sc.nextLine();
        while(loai.equals("IOS") && !a.laIOS(MaSP) ){
            System.out.print("Ma khong ton tai trong danh sach(Ban co muon xem danh sach san pham Y/phimbatky): ");
            c = sc.nextLine();
            if(c.equals("Y")){
            a.xuatSPIOS();
            }
            System.out.print("Vui long nhap lai ma san pham: ");
            MaSP = sc.nextLine();
        }
        while(loai.equals("Android") && !a.laAndroid(MaSP) ){
            System.out.print("Ma khong ton tai trong danh sach(Ban co muon xem danh sach san pham Y/phimbatky): ");
            c = sc.nextLine();
            if(c.equals("Y")){
            a.xuatSPAndroid();
            }
            System.out.print("Vui long nhap lai ma san pham: ");
            MaSP = sc.nextLine();
        }
        if(a.checkMASP(MaSP).getSoLuong()==0){
            System.out.println("Khong co san pham de mua");
        return;
        }
        sanPham[k] = a.checkMASP(MaSP);
        System.out.print("San pham da chon con lai so luong " + sanPham[k].getSoLuong()+" ban muon lay bao nhieu: ");
        int soluong = sc.nextInt();
        while(soluong>sanPham[k].getSoLuong()){
            System.out.print("Vui long nhap lai so luong vi ko du nhu cau: ");
            soluong = sc.nextInt();
        }
        sanPham[k].setSoLuong(sanPham[k].getSoLuong()-soluong);
        a.ghifile();
        k++;
    }
    @Override
    public int compareTo(HoaDon o) {
        return this.maHoaDon.compareTo(o.maHoaDon);
    }
    public void xuat() {
       float sum = 0;
       for(int i=0;i<k;i++){
                sum += sanPham[i].getDonGia()*sanPham[i].getSoLuong();
            }
            System.out.println("Ma Hoa Don: " + maHoaDon + "| Ma nhan vien: " + maNhanVien + "| Ma khach hang: " + maKhachHang + "| gio la: " + gioLap + "| tong tien: " + sum );
            for(int i=0;i<k;i++){
                System.out.println(sanPham[i]);
            }
    }
    
}
