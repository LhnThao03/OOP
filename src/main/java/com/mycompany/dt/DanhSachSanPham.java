package com.mycompany.dt;

import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class DanhSachSanPham implements Interface_File{
  SanPham[] sp = new SanPham[100];
         int n=0;
         String kiemtra;
    transient Scanner sc = new Scanner(System.in);

    public DanhSachSanPham() {
    }
    
    void nhap(){
        docfile();
        System.out.print("Nhap so luong san pham: ");
        int m = n;
        n += sc.nextInt();
        sc.nextLine();
        int j =-1;
        String MaSP;
          for(int i=m;i<n;i++){
               System.out.println("Nhap san pham thu "+ (i+1));
               System.out.print("La san pham IOS/Android: ");
              kiemtra = sc.nextLine();
              while(!kiemtra.equals("IOS") && !kiemtra.equals("Android")){
              System.out.print("La san pham IOS/Android: ");
              kiemtra = sc.nextLine();
              }
              if(kiemtra.equals("IOS")){
                  System.out.print("Phien ban ios: ");
              sp[i] = new iOS(sc.nextFloat());
              sc.nextLine();
              }else{
                  System.out.print("Hang san xuat: ");
                  sp[i] = new Android(sc.nextLine());
              }
                 System.out.print("Ma san pham: ");
               MaSP = sc.nextLine();
            while(i!=0){
            ++j;
         if(j==i){
        break;
        }
        if(sp[j].getMaSanPham().equals(MaSP)||MaSP.equals("")){
                System.out.println("Ma phieu nhap bi trung hoac rong vui long nhap lai");
                MaSP = sc.nextLine();
                j=-1;
            }
        }
          sp[i].setMaSanPham(MaSP);
            sp[i].nhap();
            j=-1;
        }
          --n;
          ghifile();
          ++n;
    }
    void add(){
        docfile();
        String MaSP;
        int j =-1;
        System.out.println("Them san pham thu "+ (n+1));
        System.out.print("La san pham IOS/Android: ");
              kiemtra = sc.nextLine();
              while(!kiemtra.equals("IOS") && !kiemtra.equals("Android")){
              System.out.print("La san pham IOS/Android: ");
              kiemtra = sc.nextLine();
              }
              if(kiemtra.equals("IOS")){
                  System.out.print("Phien ban ios: ");
              sp[n] = new iOS(sc.nextFloat());
              sc.nextLine();
              }else{
                  System.out.print("Hang san xuat: ");
                  sp[n] = new Android(sc.nextLine());
              }
                System.out.print("Ma san pham: ");
               MaSP = sc.nextLine();
        while(n!=0){
            ++j;
         if(j==n){
        break;
        }
        if(sp[j].getMaSanPham().equals(MaSP)||MaSP.equals("")){
                System.out.println("Ma san pham bi trung hoac rong vui long nhap lai");
                MaSP = sc.nextLine();
                j=-1;
            }
        }
        sp[n].setMaSanPham(MaSP);
        sp[n].nhap();
        ghifile();
        ++n;
    }
    iOS[] TimSPIOS(){
        docfile();
        iOS[] spIos = new iOS[n];
        int k =0;
        for(int i =0;i<n;i++){
        if(sp[i] instanceof iOS){
        spIos[k] = (iOS)sp[i];
        k++;
        }
        }
        return Arrays.copyOf(spIos,k);
    }
    Android[] TimSPAndroid(){
        docfile();
        Android[] spAndroid = new Android[n];
        int k =0;
        for(int i =0;i<n;i++){
        if(sp[i] instanceof Android){
        spAndroid[k] = (Android)sp[i];
        k++;
        }
        }
        return Arrays.copyOf(spAndroid,k);
    }
     void xoa(){
         docfile();
        String c = "Y";
        if(n==0){
            System.out.println("Khong co san pham de xoa");
            return;
        }else if(n>=0){
            ghifile2();
            while(c.equals("Y")){
            System.out.println("Nhap ma san pham muon xoa");
            String MaSP = sc.nextLine();
            for(int i=0;i<n;i++){
            if(sp[i].getMaSanPham().equals(MaSP)){
                System.out.println("Tim thay san pham theo ma "+MaSP+" co thong tin nhu sau");
                sp[i].xuatBody2();
                for(int j=i;j<n-1;j++){
                sp[j] = sp[j+1];
                }
                n = n-2;
                System.out.println("Xoa thanh cong");
                ghifile();
                ++n;
                return;
            }
            }
            System.out.print("Khong tim thay san pham co ma "+MaSP+ " trong danh sach ban co muon nhap lai cho chinh xac?(Y/Ky tu bat ky): ");
            c = sc.nextLine();
            }
    }      
     }
    void xuat(){
        docfile();
        for(int i=0;i<n;i++){
            System.out.println("*--------------------------San pham "+(i+1)+"---------------------------------*");
           sp[i].xuatBody2();
        }
    }
    void xuatSPIOS(){
    iOS[] spios = TimSPIOS();
    for(int i=0;i<spios.length;i++){
            System.out.println("*--------------------------San pham "+(i+1)+"---------------------------------*");
           spios[i].xuatBody2();
        }
    }
    
    boolean laIOS(String masp){
        docfile();
    for(int i=0;i<n;i++){
    if(sp[i].getMaSanPham().equals(masp)&& sp[i] instanceof iOS) return true;
    }
    return false;
    }
     boolean laAndroid(String masp){
         docfile();
    for(int i=0;i<n;i++){
    if(sp[i].getMaSanPham().equals(masp)&& sp[i] instanceof Android) return true;
    }
    return false;
    }
    void xuatSPAndroid(){
    Android[] spAndroid =TimSPAndroid();
       for(int i=0;i<spAndroid.length;i++){
            System.out.println("*--------------------------San pham "+(i+1)+"---------------------------------*");
           spAndroid[i].xuatBody2();
        }
    }
    void timSanPhamtheoMa(){  
        docfile();
        String c = "Y";
        if(n==0){
            System.out.println("Khong co san pham trong danh sach");
            return;
        }else if(n>=0){
            while(c.equals("Y")){
            System.out.print("Nhap ma san pham muon tim: ");
            String MaSP = sc.nextLine();
            for(int i=0;i<n;i++){
            if(sp[i].getMaSanPham().equals(MaSP)){
                System.out.println("Tim thay san pham theo ma "+MaSP+" co thong tin nhu sau");
                sp[i].xuatBody2();
                return;
            }
            }
            System.out.print("Khong tim thay san pham co ma "+MaSP+ " trong danh sach ban co muon nhap lai cho chinh xac?(Y/Ky tu bat ky): ");
            c = sc.nextLine();
            }
    }
    }
    SanPham checkMASP(String MaSP){
     docfile();
     for(int i=0;i<n;i++){
     if(sp[i].getMaSanPham().equals(MaSP)) return sp[i];
     }
     return null;
    }
    void Sapxeptheoma(){
        docfile();
        SanPham temp;
        for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
        if(sp[i].getMaSanPham().compareTo(sp[j].getMaSanPham()) >0){
            temp = sp[i];
            sp[i] = sp[j];
            sp[j]= temp;
        }
        }
    }
        ghifile();
    }

    public int getN() {
        return n;
    }
    void timSPtheoMa(){  
        docfile();
        String c = "Y";
        if(n==0){
            System.out.println("Khong co san pham trong danh sach");
            return;
        }else if(n>=0){
            while(c.equals("Y")){
            System.out.print("Nhap san pham muon tim: ");
            String MaSP = sc.nextLine();
            for(int i=0;i<n;i++){
            if(sp[i].getMaSanPham().equals(MaSP)){
                if(sp[i] instanceof iOS ){
                System.out.println("Tim thay san pham theo ma "+MaSP+" la san pham IOS  co thong tin nhu sau");
                sp[i].xuatBody2();}
                else{
                System.out.println("Tim thay san pham theo ma "+MaSP+" la san pham Android  co thong tin nhu sau");
                sp[i].xuatBody2();
                }
                return;
            }
            }
            System.out.print("Khong tim thay san pham co ma "+MaSP+ " trong danh sach ban co muon nhap lai cho chinh xac?(Y/Ky tu bat ky): ");
            c = sc.nextLine();
            }
    }
    }
     void TimSPTheoTen(){
        docfile();
        String c = "Y";
        boolean check = false;
      if(n==0){
            System.out.println("Khong co san pham de tim");
            return;
        }else if(n>=0){
            while(c.equals("Y")){
        System.out.print("Nhap ten san pham muon tim: ");
        String TENSP = sc.nextLine();
        for(int i=0;i<n;i++){
            if(sp[i].getTenSanPham().lastIndexOf(TENSP)>=0){
                sp[i].xuatBody2();
                check = true;
            }
        }
        if(check){
        break;
        }
          System.out.println("Khong tim thay san pham co ten "+TENSP+" trong danh sach ban co muon nhap lai cho chinh xac?(Y/Ky tu bat ky)");
          c = sc.nextLine();
        }    
        }
    }
    void Sua(){
        docfile();
        int j = -1;
         String c = "Y";
         int m = -1;
         if(n==0){
            System.out.println("Khong co san pham trong danh sach de sua");
            return;
        }
         while(j==-1 && c.equals("Y")){
        System.out.print("Nhap ma san pham muon sua: ");
        String MaSP = sc.nextLine();
        for(int i=0;i<n;i++){
        if(sp[i].getMaSanPham().equals(MaSP)){
        j = i;
        break;
        }
        }
        if(j==-1){
            System.out.print("Ma san pham khong ton tai ban co muon nhap lai cho chinh xac?(Y/hoac bat ky ki tu): ");
            c = sc.nextLine();
        }
        }
        if(j !=-1 ){
            int choose;
            String MaSP;
        System.out.println("=================================");
            System.out.println("Ma san pham-------------1");
            System.out.println("Ten--------2");
            System.out.println("Don gia------------3");
            System.out.println("Nam san xuat-----------------4");
            System.out.println("Chi tiet san pham----------------5");
            System.out.print("Chon thong tin muon sua: ");
            choose = sc.nextInt();
            switch(choose){
                case 1:
                    sc.nextLine();
                    System.out.print("Ma san pham: ");
                    MaSP = sc.nextLine();
                  while(n!=0){
            ++m;
         if(m==n){
        break;
        }
        if(sp[m].getMaSanPham().equals(MaSP)){
                System.out.println("Ma san pham bi trung vui long nhap lai");
                MaSP = sc.nextLine();
                m=-1;
            }
        }
                    sp[j].setMaSanPham(MaSP);                    
                    break;
                case 2: 
                    sc.nextLine();
                    System.out.println("Ten san pham: ");
                    sp[j].setTenSanPham(sc.nextLine());
                 case 3: 
                System.out.print("Don gia: ");
                sp[j].setDonGia(sc.nextInt());
                break;
                 case 4: 
                    System.out.print("Nam san xuat: ");
                    sp[j].setNamSX(sc.nextInt());
                    break;
                    case 5: 
                        sp[j].getChitietSP().sua();
                        break;
    }
        }
        System.out.println("Sua hoan tat");
            ghifile();
    }
    void mua(){
         HoaDon hd = new HoaDon();
            System.out.print("Ban muon mua san pham IOS/Android: ");
              kiemtra = sc.nextLine();
              while(!kiemtra.equals("IOS") && !kiemtra.equals("Android")){
              System.out.print("Ban muon mua san pham IOS/Android: ");
              kiemtra = sc.nextLine();
              }
              if(kiemtra.equals("IOS")){
                  xuatSPIOS();
                  hd.ChonSP(kiemtra);
              }else{
                  xuatSPAndroid();
                  hd.ChonSP(kiemtra);
              }
    }

    public void thongKeTheoSL() {
        docfile();
        int d = 0;
        for (int i = 0; i < n; i++) {
            d += sp[i].getSoLuong();
        }
        System.out.println("Tổng số lượng sản phầm có trong cửa hàng: " + d + " chiếc");
    }

    public void thongKeTheoHDH() {
        docfile();
        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i < n; i++) {
            if (sp[i] instanceof iOS) {
                d1++;
            }
            if (sp[i] instanceof Android) {
                d2++;
            }
        }
        System.out.println("Tổng sản phầm có HDH IOS trong cửa hàng là: " + d1 + " loại");
        System.out.println("Tổng sản phầm có HDH ANDROID trong cửa hàng là: " + d2 + " loại");
    }
    public void ThongKe() throws IOException {
        int x;
        do {
            System.out.print(" =====================Thống kê====================\n");
            System.out.print("| ~~~1. Thống kê loại sản phẩm                   |\n");
            System.out.print("| ~~~2.Thống kê tổng số lượng                    |\n");
            System.out.print("| ~~~3.Thống kê hệ điều hành                     |\n");
            System.out.print("| ~~~4.Thống kê tổng tiền                        |\n");
            System.out.print("| ~~~0. Thoát Chương Trình                       |\n");
            System.out.print(" =================================================\n");
            System.out.print(">>> Bạn chọn là : ");
             x = Integer.valueOf(sc.nextLine());
            switch (x) {
                case 1:
                    thongKeTheoHDH();
                    break;
                case 2:
                    thongKeTheoSL();
                    break;
                case 3:
                    thongKeTheoTongTien();
                    break;
            }
        } while (x != 0);
    }
    public void thongKeTheoTongTien() {
        docfile();
        float d = 0;
        for (int i = 0; i < n; i++) {
            d += sp[i].getSoLuong() * sp[i].getDonGia();
        }
        System.out.println("Tổng tiền hàng trong cửa hàng: " + d + " VND");
    }
  @Override
        public void ghifile() {
            FileOutputStream os;
        try {
            os = new FileOutputStream("SanPham.txt");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for(int i = 0 ;i<=n;i++){
            oos.writeObject(sp[i]);
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
            writer = new PrintWriter("SanPham.txt");
            writer.write("");
        writer.flush();
        writer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        }

  @Override
    public void docfile(){
    n=0;
            FileInputStream is;
        try {
            is = new FileInputStream("SanPham.txt");
             ObjectInputStream ois = new ObjectInputStream(is);
                 while(true){
                   Object obj = ois.readObject();
                   if(obj == null) {
                   break;
                   }
            sp[n] = (SanPham)obj;
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