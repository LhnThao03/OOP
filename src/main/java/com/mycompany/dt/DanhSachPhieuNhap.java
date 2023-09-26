/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dt;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DanhSachPhieuNhap {
        PhieuNhap[] phieuNhap = new PhieuNhap[100];
         int n=0;
    transient Scanner sc = new Scanner(System.in);
    void nhap(){
        docfile();
        System.out.println("Nhap so luong phieu nhap");
        int m = n;
        n += sc.nextInt();
        sc.nextLine();
        int j =-1;
        String MaPN;
          for(int i=m;i<n;i++){
              phieuNhap[i] = new PhieuNhap();
            System.out.println("Nhap phieu nhap thu "+ (i+1));
                 System.out.print("Ma phieu nhap: ");
               MaPN = sc.nextLine();
            while(i!=0){
            ++j;
         if(j==i){
        break;
        }
        if(phieuNhap[j].getMaPhieuNhap().equals(MaPN)){
                System.out.println("Ma phieu nhap bi trung vui long nhap lai");
                MaPN = sc.nextLine();
                j=-1;
            }
        }
          phieuNhap[i].setMaPhieuNhap(MaPN);
            phieuNhap[i].Nhap();
            j=-1;
        }
          ghifile();
    }
    void add(){
        docfile();
        String MaPN;
        int j =-1;
        phieuNhap[n] = new PhieuNhap();
        System.out.println("Them phieu nhap thu "+ (n+1));
        System.out.print("Ma phieu nhap: ");
        MaPN = sc.nextLine();
        while(n!=0){
            ++j;
         if(j==n){
        break;
        }
        if(phieuNhap[j].getMaPhieuNhap().equals(MaPN)){
                System.out.println("Ma phieu nhap bi trung vui long nhap lai");
                MaPN = sc.nextLine();
                j=-1;
            }
        }
        phieuNhap[n].setMaPhieuNhap(MaPN);
        phieuNhap[n].Nhap();
           ghifile();
        ++n;
    }
     void xoa(){
         docfile();
        String c = "Y";
        if(n==0){
            System.out.println("Khong co phieu nhap de xoa");
            return;
        }else if(n>=0){
            ghifile2();
            while(c.equals("Y")){
            System.out.println("Nhap ma phieu nhap muon xoa");
            String MaPN = sc.nextLine();
            for(int i=0;i<n;i++){
            if(phieuNhap[i].getMaPhieuNhap().equals(MaPN)){
                System.out.println("Tim thay phieu nhap theo ma "+MaPN+" co thong tin nhu sau");
                phieuNhap[i].xuat();      
                for(int j=i;j<n-1;j++){
                phieuNhap[j] = phieuNhap[j+1];
                }
                n = n-2;
                System.out.println("Xoa thanh cong");
                ghifile();
                ++n;
                return;
            }
            }
            System.out.print("Khong tim thay phieu nhap co ma "+MaPN+ " trong danh sach ban co muon nhap lai cho chinh xac?(Y/Ky tu bat ky): ");
            c = sc.nextLine();
            }
    }      
     }
    void xuat(){
        docfile();
        for(int i=0;i<n;i++){
            System.out.println("*--------------------------Phieu Nhap "+(i+1)+"---------------------------------*");
           phieuNhap[i].xuat();
        }
    }
    void timPhieuNhaptheoMa(){  
        docfile();
        String c = "Y";
        if(n==0){
            System.out.println("Khong co phieu nhap trong danh sach");
            return;
        }else if(n>=0){
            while(c.equals("Y")){
            System.out.print("Nhap ma phieu nhap muon tim: ");
            String MaPN = sc.nextLine();
            for(int i=0;i<n;i++){
            if(phieuNhap[i].getMaPhieuNhap().equals(MaPN)){
                System.out.println("Tim thay phieu nhap theo ma "+MaPN+" co thong tin nhu sau");
                phieuNhap[i].xuat();
                return;
            }
            }
            System.out.print("Khong tim thay phieu nhap co ma "+MaPN+ " trong danh sach ban co muon nhap lai cho chinh xac?(Y/Ky tu bat ky): ");
            c = sc.nextLine();
            }
    }
    }
    void Sapxeptheoma(){
        docfile();
        PhieuNhap temp;
        for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
        if(phieuNhap[i].getMaPhieuNhap().compareTo(phieuNhap[j].getMaPhieuNhap()) >0){
            temp = phieuNhap[i];
            phieuNhap[i] = phieuNhap[j];
            phieuNhap[j]= temp;
        }
        }
    }
        ghifile();
    }

    public int getN() {
        return n;
    }
        
    void Sua(){
        docfile();
        int j = -1;
         String c = "Y";
         int m = -1;
         if(n==0){
            System.out.println("Khong co phieu nhap trong danh sach de sua");
            return;
        }
         while(j==-1 && c.equals("Y")){
        System.out.print("Nhap ma phieu nhap muon sua: ");
        String MaPN = sc.nextLine();
        for(int i=0;i<n;i++){
        if(phieuNhap[i].getMaPhieuNhap().equals(MaPN)){
        j = i;
        break;
        }
        }
        if(j==-1){
            System.out.print("Ma phieu nhap khong ton tai ban co muon nhap lai cho chinh xac?(Y/hoac bat ky ki tu): ");
            c = sc.nextLine();
        }
        }
        if(j !=-1 ){
            int choose;
            String MaPN;
        System.out.println("=================================");
            System.out.println("Ma phieu nhap-------------1");
            System.out.println("Ngay lap--------2");
            System.out.println("Gio lap------------3");
            System.out.println("Ma nhan vien-----------------4");
            System.out.println("Ma nha cung cap----------------5");
            System.out.println(":Them san pham ---- 6");
            System.out.print("Chon thong tin muon sua: ");
            choose = sc.nextInt();
            switch(choose){
                case 1:
                    sc.nextLine();
                    System.out.print("Ma phieu nhap: ");
                    MaPN = sc.nextLine();
                  while(n!=0){
            ++m;
         if(m==n){
        break;
        }
        if(phieuNhap[m].getMaPhieuNhap().equals(MaPN)){
                System.out.println("Ma phieu nhap bi trung vui long nhap lai");
                MaPN = sc.nextLine();
                m=-1;
            }
        }
                    phieuNhap[j].setMaPhieuNhap(MaPN);
                    
                    break;
                case 2: 
                    sc.nextLine();
                    System.out.print("Ngay lap: ");
                    phieuNhap[j].setNgayNhap(LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt()));
                    break;
                 case 3: 
                System.out.print("Gio lap: ");
                phieuNhap[j].setGioNhap(LocalTime.of(sc.nextInt(),sc.nextInt()));
                break;
                 case 4: 
                     sc.nextLine();
                    System.out.print("Ma nhan vien: ");
                    DanhSachNhanVien dsnv = new DanhSachNhanVien();
                    dsnv.docfile();
                    String MaNV = sc.nextLine();
        String d = "No";
        while(true){
        if(dsnv.checkMANV(MaNV)!=null){
            phieuNhap[j].nhanvien = dsnv.checkMANV(MaNV);
        break;
        }
            System.out.print("Khong tim thay nhan vien trong danh sach(Ban co muon xem danh sach nhan vien nhan Y/phim bat ky): ");
            d = sc.nextLine();
            if(d.equals("Y")){
                dsnv.xuat();
            }
            System.out.print("Nhap lai ma nhan vien: ");
            MaNV = sc.nextLine();
        }
                    break;
                    case 5: 
                        sc.nextLine();
               System.out.print("Nhap ma nha cung cap(da ton tai trong danh sach nha cung cap): ");
                   String MaNCC = sc.nextLine();
        String b = "No";
        while(true){
        DanhSachNhaCungCap dsncc = new DanhSachNhaCungCap();
        dsncc.docfile();
        if(dsncc.CheckMaNCC(MaNCC)!=null){
            phieuNhap[j].nhacungcap = dsncc.CheckMaNCC(MaNCC);
        break;
        }
            System.out.print("Khong tim thay nha cung cap trong danh sach(Ban co muon xem danh sach nha cung cap nhan Y/phim bat ky): ");
            b = sc.nextLine();
            if(b.equals("Y")){
                dsncc.xuat();
            }
            System.out.print("Nhap lai ma nha cung cap: ");
            MaNCC = sc.nextLine();
        }
                    break;
                    case 6:
                        sc.nextLine();
                       System.out.println("Them san pham  thu "+ (phieuNhap[j].getN()+1));
        System.out.print("Ma ma san pham: ");
        String MaSP = sc.nextLine();
        while(n!=0){
            ++j;
         if(j==phieuNhap[j].getN()){
        break;
        }
        if(phieuNhap[j].getMaPhieuNhap().equals(MaSP)){
                System.out.println("Ma san pham bi trung vui long nhap lai");
                MaSP = sc.nextLine();
                j=-1;
            }
        }
        phieuNhap[j].setMaPhieunhap(MaSP);
        phieuNhap[j].setChiTietPN();
                       break;
     
            }
            System.out.println("Sua hoan tat");
            ghifile();
        }        
    }
        void ghifile() {
            FileOutputStream os;
        try {
            os = new FileOutputStream("PhieuNhap.txt");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for(int i = 0 ;i<=n;i++){
            oos.writeObject(phieuNhap[i]);
            }
            oos.close();
            os.close();
        } catch (FileNotFoundException ex) {
      ex.printStackTrace();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
     void ghifile2(){
         PrintWriter writer;
        try {
            writer = new PrintWriter("PhieuNhap.txt");
            writer.write("");
        writer.flush();
        writer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        }

    void docfile(){
    n=0;
            FileInputStream is;
        try {
            is = new FileInputStream("PhieuNhap.txt");
             ObjectInputStream ois = new ObjectInputStream(is);
                 while(true){
                   Object obj = ois.readObject();
                   if(obj == null) {
                   break;
                   }
            phieuNhap[n] = (PhieuNhap)obj;
            ++n;
            }  
            ois.close();
            is.close();
        } catch (FileNotFoundException ex) {
             ex.printStackTrace();
        } catch (IOException ex) {
             System.out.println("");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
