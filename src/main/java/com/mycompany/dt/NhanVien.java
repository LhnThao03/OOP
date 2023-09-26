package com.mycompany.dt;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;
public class NhanVien implements Serializable{

    String MaNV, TenNV, DiaChi, SDT,sex;
    float luong;

    public NhanVien(float luong) {
        this.luong = luong;
    }
    
    LocalDate NgaySinh;
    transient Scanner sc = new Scanner(System.in);
    public NhanVien() {
    }

    public NhanVien(String MaNV) {
        this.MaNV = MaNV;
    }
    
    public NhanVien(String MaNV, String TenNV, LocalDate NgaySinh, String DiaChi, String SDT) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(LocalDate NgaySinh) {
        this.NgaySinh = NgaySinh;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }
    void Nhap(){
        System.out.print("Nhap ten nhan vien: ");
        TenNV = sc.nextLine();
        System.out.print("Ngay sinh cua nhan vien: ");
        NgaySinh = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        sc.nextLine();
        System.out.print("Gioi tinh: ");
        this.sex = sc.nextLine();
        System.out.print("Dia chi: ");
        DiaChi = sc.nextLine();
        System.out.print("SDT: ");
        SDT = sc.nextLine();
        System.out.print("Luong co ban: ");
        luong = sc.nextFloat();
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
        final NhanVien other = (NhanVien) obj;
        return Objects.equals(this.MaNV, other.MaNV);
    }

    @Override
    public String toString() {
        return  " MaNV: " + MaNV + ", TenNV: " + TenNV + ", DiaChi: " + DiaChi + ", SDT: " + SDT + ", NgaySinh: " + NgaySinh +",Luong: "+luong +"\n";
    }

//    @Override
//    public int compareTo(NhanVien o) { 
//        return this.MaNV.compareTo(o.MaNV);
//    }
    
}
