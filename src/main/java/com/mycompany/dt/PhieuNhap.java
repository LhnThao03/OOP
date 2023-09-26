package com.mycompany.dt;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class PhieuNhap implements Serializable{

    String maPhieuNhap;
    LocalDate ngayNhap;
    LocalTime gioNhap;
    int tongTien = 0;
    ChiTietPhieuNhap[] phieunhap = new ChiTietPhieuNhap[100];
    NhaCungCap nhacungcap;
    NhanVien nhanvien;    
    int n =0;
    transient Scanner sc = new Scanner(System.in);
    
    public PhieuNhap() {
        this.ngayNhap = LocalDate.now();
        this.gioNhap = LocalTime.now();
    }

    public PhieuNhap(String maPhieuNhap, LocalDate ngayNhap, LocalTime gioNhap, ChiTietPhieuNhap[] phieunhap, NhaCungCap nhacungcap, NhanVien nhanvien) {
        this.maPhieuNhap = maPhieuNhap;
        this.ngayNhap = ngayNhap;
        this.gioNhap = gioNhap;
        this.phieunhap = phieunhap;
        this.nhacungcap = nhacungcap;
        this.nhanvien = nhanvien;
    }
    void Nhap(){
        DanhSachNhanVien dsnv = new DanhSachNhanVien();
        dsnv.docfile();
            if(dsnv.getN()==0){
            System.out.println("Vui long bo sung nhan vien vao danh sach truoc khi tao phieu nhap");
            return;
        }
        DanhSachNhaCungCap dsncc = new DanhSachNhaCungCap();
        dsncc.docfile();
        if(dsncc.getN()==0){
            System.out.println("Vui long bo sung nha cung cap vao danh sach truoc khi tao phieu nhap");
            return;
        }
        System.out.print("Nhap ngay thang nam nhap hang: ");
        this.ngayNhap = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.print("Nhap thoi gian cu the(giay-phut): ");
        this.gioNhap = LocalTime.of(sc.nextInt(), sc.nextInt());
        sc.nextLine();
        System.out.print("Nhap ma nha cung cap: ");
          String MaNCC = sc.nextLine();
        String b = "No";
        while(true){
        if(dsncc.CheckMaNCC(MaNCC)!=null){
            nhacungcap = dsncc.CheckMaNCC(MaNCC);
        break;
        }
            System.out.print("Khong tim nha cung cap  trong danh sach(Ban co muon xem danh sach nhan vien nhan Y/phim bat ky): ");
            b = sc.nextLine();
            if(b.equals("Y")){
                dsncc.xuat();
            }
            System.out.print("Nhap lai ma nha cung cap: ");
            MaNCC = sc.nextLine();
        }
        System.out.print("Nhap ma nhan vien: ");
        String MaNV = sc.nextLine();
        String c = "No";
        while(true){
        if(dsnv.checkMANV(MaNV)!=null){
            this.nhanvien = dsnv.checkMANV(MaNV);
        break;
        }
            System.out.print("Khong tim thay nhan vien trong danh sach(Ban co muon xem danh sach nhan vien nhan Y/phim bat ky): ");
            c = sc.nextLine();
            if(c.equals("Y")){
                dsnv.xuat();
            }
            System.out.println("Nhap lai ma nhan vien: ");
            MaNV = sc.nextLine();
        }
        System.out.print("So loai san pham: ");
        this.n = sc.nextInt();
        String MaSP;
        int j = -1;
        sc.nextLine();
        for(int i=0;i<n;i++){
              phieunhap[i] = new ChiTietPhieuNhap();
            System.out.println("Nhap san pham thu "+ (i+1));
                 System.out.print("Ma san pham: ");
               MaSP = sc.nextLine();
            while(i!=0){
            ++j;
         if(j==i){
        break;
        }
        if(phieunhap[j].getMaSP().equals(MaSP)){
                System.out.println("Ma san pham bi trung vui long nhap lai");
                MaSP = sc.nextLine();
                j=-1;
            }
        }
          phieunhap[i].setMaSP(MaSP);
            phieunhap[i].Nhap();
            j=-1;
        }
        }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPN) {
        this.maPhieuNhap = maPN;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public LocalTime getGioNhap() {
        return gioNhap;
    }

    public void setGioNhap(LocalTime gioNhap) {
        this.gioNhap = gioNhap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

     public ChiTietPhieuNhap[] getPhieunhap() {
         return phieunhap;
     }

     public void setMaPhieunhap(String MaSP) {
         phieunhap[n] = new ChiTietPhieuNhap();
         this.phieunhap[this.n].setMaSP(MaSP);
     }

     public void setChiTietPN(){
     this.phieunhap[n].Nhap();
     ++n;
     }
    public NhaCungCap getNhaCungCap() {
        return nhacungcap;
    }

    public void setNhaCungCap(NhaCungCap nhacungcap) {
        this.nhacungcap = nhacungcap;
    }

    public NhanVien getNhanVien() {
        return nhanvien;
    }

    public void setNhanVien(NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    // void xuat(){
    //     System.out.println("Ma phieu nhap: "+maPN+" Ma nha cung cap: "+nhacungcap.getMaNCC()+" Ma nhan vien: "+nhanvien.getMaNV());
    //     System.out.println("Ngay lap: "+ngayNhap+" Gio nhap: "+gioNhap);
    //     System.out.println("_______________________________________________");
    // for(int i=0;i<n;i++){
    //     System.out.println(phieunhap[i]);
    // }
    // }

    public void xuat(){
        float sum = 0;
        System.out.printf("Ma phieu nhap: %2s | ", getMaPhieuNhap());
        System.out.printf("Ma nha cung cap: %2s | ", getNhaCungCap().getMaNCC());
        System.out.printf("Ma nhan vien: %2s | ", getNhanVien().getMaNV());
        System.out.printf("Ngay nhap: %5s | ", getNgayNhap());
        System.out.printf("Gio nhap: %2s |", getGioNhap());
        System.out.print("\n+ - - - - - - + - - - - - - - + - - - - - - - - - - + - - - - - - - - - - + - - - - - +\n");
             for(int i=0;i<n;i++){
         System.out.println(phieunhap[i]);
         sum += phieunhap[i].getThanhTien();
     }
             
             System.out.println("Tong tien: "+sum);
    }
}
 
