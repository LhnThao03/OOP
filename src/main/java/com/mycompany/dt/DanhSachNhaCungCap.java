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
import java.io.File;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class DanhSachNhaCungCap {
     transient Scanner sc = new Scanner(System.in);
     NhaCungCap nhacungcap[] = new NhaCungCap[100];
     int n = 0;
    void nhap(){
        docfile();
        System.out.print("Nhap so luong nha cung cap: ");
        int m = n;
        n += sc.nextInt();
        sc.nextLine();
        int j =-1;
        String MaNCC;
          for(int i=m;i<n;i++){
              nhacungcap[i] = new NhaCungCap();
            System.out.println("Nhap nha cung cap thu "+ (i+1));
                 System.out.print("Ma nha cung cap: ");
               MaNCC = sc.nextLine();
            while(i!=0){
            ++j;
         if(j==i){
        break;
        }
        if(nhacungcap[j].getMaNCC().equals(MaNCC)){
                System.out.println("Ma nha cung cap bi trung vui long nhap lai");
                MaNCC = sc.nextLine();
                j=-1;
            }
        }
          nhacungcap[i].setMaNCC(MaNCC);
            nhacungcap[i].Nhap();
            j=-1;
        }
          ghifile();
    }
    void add(){
        docfile();
        String MaNCC;
        int j =-1;
        nhacungcap[n] = new NhaCungCap();
        System.out.println("Them nha cung cap thu "+ (n+1));
        System.out.print("Ma ma nha cung cap: ");
        MaNCC = sc.nextLine();
        while(n!=0){
            ++j;
         if(j==n){
        break;
        }
        if(nhacungcap[j].getMaNCC().equals(MaNCC)){
                System.out.println("Ma cung cap bi trung vui long nhap lai");
                MaNCC = sc.nextLine();
                j=-1;
            }
        }
        nhacungcap[n].setMaNCC(MaNCC);
        nhacungcap[n].Nhap();
           ghifile();
        ++n;
    }
     void xoa(){
         docfile();
        String c = "Y";
        if(n==0){
            System.out.println("Khong co nha cung cap de xoa");
            return;
        }else if(n>=0){
            ghifile2();
            while(c.equals("Y")){
            System.out.println("Nhap ma cung cap muon xoa");
            String MaNCC = sc.nextLine();
            for(int i=0;i<n;i++){
            if(nhacungcap[i].getMaNCC().equals(MaNCC)){
                System.out.println("Tim thay nha cung cap theo ma "+MaNCC+" co thong tin nhu sau");
                System.out.println(nhacungcap[i]);      
                for(int j=i;j<n-1;j++){
                nhacungcap[j] = nhacungcap[j+1];
                }
                n = n-2;
                System.out.println("Xoa thanh cong");
                ghifile();
                ++n;
                return;
            }
            }
            System.out.print("Khong tim thay nha cung cap co ma "+nhacungcap+ " trong danh sach ban co muon nhap lai cho chinh xac?(Y/Ky tu bat ky): ");
            c = sc.nextLine();
            }
    }      
     }
    void xuat(){
        docfile();
        for(int i=0;i<n;i++){
            System.out.println("STT "+(i+1)+": "+nhacungcap[i]);
        }
    }
    void timNCCtheoMa(){  
        docfile();
        String c = "Y";
        if(n==0){
            System.out.println("Khong co nha cung cap de tim");
            return;
        }else if(n>=0){
            while(c.equals("Y")){
            System.out.println("Nhap ma nha cung cap muon tim");
            String MaNCC = sc.nextLine();
            for(int i=0;i<n;i++){
            if(nhacungcap[i].getMaNCC().equals(MaNCC)){
                System.out.println("Tim thay nha cung cap theo ma "+MaNCC+" co thong tin nhu sau");
                System.out.println(nhacungcap[i]);       
                return;
            }
            }
            System.out.print("Khong tim thay nha cung cap co ma "+MaNCC+ " trong danh sach ban co muon nhap lai cho chinh xac?(Y/Ky tu bat ky): ");
            c = sc.nextLine();
            }
    }
    }
    NhaCungCap CheckMaNCC(String MaNCC){
    docfile();
     for(int i=0;i<n;i++){
     if(nhacungcap[i].getMaNCC().equals(MaNCC)) return nhacungcap[i];
     }
     return null;
    }
    void TimNCCTheoTen(){
        docfile();
        String c = "Y";
        boolean check = false;
      if(n==0){
            System.out.println("Khong co nha cung cap de tim");
            return;
        }else if(n>=0){
            while(c.equals("Y")){
        System.out.print("Nhap ten nha cung cap muon tim: ");
        String tenNCC = sc.nextLine();
        for(int i=0;i<n;i++){
            if(nhacungcap[i].getTenNCC().lastIndexOf(tenNCC)>=0){
                System.out.println(nhacungcap[i]);
                check = true;
            }
        }
        if(check){
        break;
        }
          System.out.println("Khong tim thay nha cung cap co ten "+tenNCC+" trong danh sach ban co muon nhap lai cho chinh xac?(Y/Ky tu bat ky)");
          c = sc.nextLine();
        }    
        }
    }
    void Sapxeptheoma(){
        docfile();
        NhaCungCap temp;
        for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
        if(nhacungcap[i].getMaNCC().compareTo(nhacungcap[j].getMaNCC()) >0){
            temp = nhacungcap[i];
            nhacungcap[i] = nhacungcap[j];
            nhacungcap[j]= temp;
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
            System.out.println("Khong co nha cung cap de sua");
            return;
        }
         while(j==-1 && c.equals("Y")){
        System.out.println("Nhap ma nha cung cap muon sua: ");
        String MaNCC = sc.nextLine();
        for(int i=0;i<n;i++){
        if(nhacungcap[i].getMaNCC().equals(MaNCC)){
        j = i;
        break;
        }
        }
        if(j==-1){
            System.out.println("Ma nha cung cap khong ton tai ban co muon nhap lai cho chinh xac?(Y/hoac bat ky ki tu): ");
            c = sc.nextLine();
        }
        }
        if(j !=-1 ){
            int choose;
            String MaNCC;
        System.out.println("=================================");
            System.out.println("Ma nha cung cap-------------1");
            System.out.println("Ten nha cung cap--------2");
            System.out.println("Dia chi-----------------3");
            System.out.println("SDT----------------4");
            System.out.print("Chon thong tin muon sua: ");
            choose = sc.nextInt();
            switch(choose){
                case 1:
                    sc.nextLine();
                    System.out.println("Ma nha cung cap: ");
                   MaNCC = sc.nextLine();
                  while(n!=0){
            ++m;
         if(m==n){
        break;
        }
        if(nhacungcap[m].getMaNCC().equals(MaNCC)){
                System.out.println("Ma nha cung cap bi trung vui long nhap lai");
                MaNCC = sc.nextLine();
                m=-1;
            }
        }
                    nhacungcap[j].setMaNCC(MaNCC);
                    
                    break;
                case 2: 
                    sc.nextLine();
                    System.out.println("Ten nha cung cap: ");
                    nhacungcap[j].setTenNCC(sc.nextLine());
                    break;
                 case 3: 
                     sc.nextLine();
                    System.out.println("Dia chi: ");
                    nhacungcap[j].setDiaChi(sc.nextLine());
                    break;
                    case 4: 
                    sc.nextLine();
                    System.out.println("SDT: ");
                    nhacungcap[j].setSDT(sc.nextLine());
                    break;
            }
            System.out.println("Sua hoan tat");
            ghifile();
        }        
    }
        void ghifile() {
            FileOutputStream os;
        try {
            os = new FileOutputStream("NhaCungCap.txt");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for(int i = 0 ;i<=n;i++){
            oos.writeObject(nhacungcap[i]);
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
            writer = new PrintWriter("NhaCungCap.txt");
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
            is = new FileInputStream("NhaCungCap.txt");
             ObjectInputStream ois = new ObjectInputStream(is);
                 while(true){
                   Object obj = ois.readObject();
                   if(obj == null) {
                   break;
                   }
            nhacungcap[n] = (NhaCungCap)obj;
            ++n;
            }  
            ois.close();
            is.close();
        } catch (FileNotFoundException ex) {
             ex.printStackTrace();
        } catch (IOException ex) {
             System.out.print("");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
