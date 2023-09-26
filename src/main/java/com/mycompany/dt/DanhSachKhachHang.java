package com.mycompany.dt;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DanhSachKhachHang {
     
    KhachHang[] khachhang = new KhachHang[100];
    int n=0;
    transient Scanner sc = new Scanner(System.in);
    void nhap(){
        docfile();
        System.out.println("Nhap nhieu khach hang: ");
        int m = n;
        n += sc.nextInt();
        sc.nextLine();
        int j =-1;
        String MaKH;
          for(int i=m;i<n;i++){
              khachhang[i] = new KhachHang();
            System.out.println("Nhap khach hang thu "+ (i+1));
                 System.out.print("Ma khach hang: ");
               MaKH = sc.nextLine();
            while(i!=0){
            ++j;
         if(j==i){
        break;
        }
        if(khachhang[j].equals(MaKH)){
                System.out.println("Ma khach hang bi trung vui long nhap lai");
                MaKH = sc.nextLine();
                j=-1;
            }
        }
          khachhang[i].setMaKH(MaKH);
            khachhang[i].nhap();
            j=-1;
        }
          --n;
          ghifile();
          ++n;
    }
    void add(){
        docfile();
        String MaKH;
        int j =-1;
        khachhang[n] = new KhachHang();
        System.out.println("Them khach hang thu "+ (n+1));
        System.out.print("Ma khach hang: ");
        MaKH = sc.nextLine();
        while(n!=0){
            ++j;
         if(j==n){
        break;
        }
        if(khachhang[j].getMaKH().equals(MaKH)){
                System.out.print("Ma khach hang bi trung vui long nhap lai: ");
                MaKH = sc.nextLine();
                j=-1;
            }
        }
        khachhang[n].setMaKH(MaKH);
        khachhang[n].nhap();
           ghifile();
           ++n;
    }
     void xoa(){
         docfile();
        String c = "Y";
        if(n==0){
            System.out.println("Khong co khach hang de xoa");
            return;
        }else if(n>=0){
            ghifile2();
            while(c.equals("Y")){
            System.out.println("Nhap ma khach hang muon xoa");
            String MaKH = sc.nextLine();
            for(int i=0;i<n;i++){
            if(khachhang[i].getMaKH().equals(MaKH)){
                System.out.println("Tim thay khach hang theo ma "+MaKH+" co thong tin nhu sau");
                System.out.println(khachhang[i]);      
                for(int j=i;j<n-1;j++){
                khachhang[j] = khachhang[j+1];
                }
                
                n =n-2;
                System.out.println("Xoa thanh cong");
                ghifile();
                ++n;
                return;
            }
            }
            System.out.print("Khong tim thay khach hang co ma "+MaKH+ " trong danh sach ban co muon nhap lai cho chinh xac?(Y/Ky tu bat ky): ");
            c = sc.nextLine();
            }
    }      
     }
    void xuat(){
        docfile();
        for(int i=0;i<n;i++){
            System.out.println("STT "+(i+1)+khachhang[i].toString());
        }
    }
    void timKHtheoMa(){  
        docfile();
        String c = "Y";
        if(n==0){
            System.out.println("Khong co khach hang de tim");
            return;
        }else if(n>=0){
            while(c.equals("Y")){
            System.out.println("Nhap ma khach hang muon tim");
            String MaKH = sc.nextLine();
            for(int i=0;i<n;i++){
            if(khachhang[i].getMaKH().equals(MaKH)){
                System.out.println("Tim thay khach hang theo ma "+MaKH+" co thong tin nhu sau");
                System.out.println(khachhang[i]);       
                return;
            }
            }
            System.out.print("Khong tim thay khach hang co ma "+MaKH+ " trong danh sach ban co muon nhap lai cho chinh xac?(Y/Ky tu bat ky): ");
            c = sc.nextLine();
            }
    }
    }
    boolean timMa(String maKH){
    docfile(); 
    for(int i=0;i<n;i++){
    if(khachhang[i].getMaKH().equals(maKH)) return true;
    }
    return false;
    }
    String LayMaCuoi(){
    return khachhang[n-1].getMaKH();
    }
    void TimKHTheoTen(){
        docfile();
        String c = "Y";
        boolean check = false;
      if(n==0){
            System.out.println("Khong co khach hang de tim");
            return;
        }else if(n>=0){
            while(c.equals("Y")){
        System.out.print("Nhap ten khach hang muon tim: ");
        String TENKH = sc.nextLine();
        for(int i=0;i<n;i++){
            if(khachhang[i].getTenKH().lastIndexOf(TENKH)>=0){
                System.out.println(khachhang[i]);
                check = true;
            }
        }
        if(check){
        break;
        }
          System.out.println("Khong tim thay khach hang co ten "+TENKH+" trong danh sach ban co muon nhap lai cho chinh xac?(Y/Ky tu bat ky)");
          c = sc.nextLine();
        }    
        }
    }
    void Sapxeptheoma(){
        docfile();
        KhachHang temp;
        for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
        if(khachhang[i].getMaKH().compareTo(khachhang[j].getMaKH()) >0){
            temp = khachhang[i];
            khachhang[i] = khachhang[j];
            khachhang[j]= temp;
        }
        }
    }
        ghifile();
    }
        
    void Sua(){
        docfile();
        int j = -1;
         String c = "Y";
         int m = -1;
         if(n==0){
            System.out.println("Khong co khach hang de sua");
            return;
        }
         while(j==-1 && c.equals("Y")){
        System.out.println("Nhap ma khach hang muon sua: ");
        String MaKH = sc.nextLine();
        for(int i=0;i<n;i++){
        if(khachhang[i].getMaKH().equals(MaKH)){
        j = i;
        break;
        }
        }
        if(j==-1){
            System.out.println("Ma khach hang khong ton tai ban co muon nhap lai cho chinh xac?(Y/hoac bat ky ki tu): ");
            c = sc.nextLine();
        }
        }
        if(j !=-1 ){
            int choose;
            String MaKH;
        System.out.println("=================================");
            System.out.println("Ma nhan vien-------------1");
            System.out.println("Ten nhan vien--------2");
            System.out.println("Dia chi-----------------3");
            System.out.println("SDT----------------4");
            System.out.print("Chon thong tin muon sua: ");
            choose = sc.nextInt();
            switch(choose){
                case 1:
                    sc.nextLine();
                    System.out.println("Ma nhan vien: ");
                    MaKH = sc.nextLine();
                  while(n!=0){
            ++m;
         if(m==n){
        break;
        }
        if(khachhang[m].getMaKH().equals(MaKH)){
                System.out.println("Ma khach hang bi trung vui long nhap lai");
                MaKH = sc.nextLine();
                m=-1;
            }
        }
                    khachhang[j].setMaKH(MaKH);
                    
                    break;
                case 2: 
                    sc.nextLine();
                    System.out.println("Ten nhan vien: ");
                    khachhang[j].setMaKH(sc.nextLine());
                    break;
                 case 3: 
                     sc.nextLine();
                    System.out.println("Dia chi: ");
                    khachhang[j].setDiaChi(sc.nextLine());
                    break;
                    case 4: 
                        sc.nextLine();
                    System.out.println("SDT: ");
                    khachhang[j].setSDT(sc.nextLine());
                    break;
                    
            }
            System.out.println("Sua hoan tat");
            ghifile();
        }        
    }
        void ghifile() {
            FileOutputStream os;
        try {
            os = new FileOutputStream("KhachHang.txt");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for(int i = 0 ;i<=n;i++){
            oos.writeObject(khachhang[i]);
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
            writer = new PrintWriter("KhachHang.txt");
             writer.write("");
        writer.flush();
        writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DanhSachKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    void docfile(){
    n = 0;
            FileInputStream is;
        try {
            is = new FileInputStream("KhachHang.txt");
             ObjectInputStream ois = new ObjectInputStream(is);
                 while(true){
                   Object obj = ois.readObject();
                   if(obj == null) {
                   break;
                   }
            khachhang[n] = (KhachHang)obj;
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
