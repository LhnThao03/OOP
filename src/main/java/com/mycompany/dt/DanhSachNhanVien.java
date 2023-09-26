package com.mycompany.dt;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DanhSachNhanVien{
    
    NhanVien[] nhanvien = new NhanVien[100];
    int n=0;

    public DanhSachNhanVien() {
    }
    transient Scanner sc = new Scanner(System.in);
    void nhap(){
        docfile();
        System.out.println("Nhap so luong nhan vien");
        int m = n;
        n += sc.nextInt();
        sc.nextLine();
        int j =-1;
        String MaNV;
          for(int i=m;i<n;i++){
              nhanvien[i] = new NhanVien();
            System.out.println("Nhap nhan vien thu "+ (i+1));
                 System.out.print("Ma NV: ");
               MaNV = sc.nextLine();
            while(i!=0){
            ++j;
         if(j==i){
        break;
        }
        if(nhanvien[j].getMaNV().equals(MaNV)){
                System.out.println("Ma nhan vien bi trung vui long nhap lai");
                MaNV = sc.nextLine();
                j=-1;
            }
        }
          nhanvien[i].setMaNV(MaNV);
            nhanvien[i].Nhap();
            j=-1;
        }
          --n;
          ghifile();
          ++n;
    }
    void add(){
        docfile();
        String MaNV;
        int j =-1;
        nhanvien[n] = new NhanVien();
        System.out.println("Them nhan vien thu "+ (n+1));
        System.out.print("Ma NV: ");
        MaNV = sc.nextLine();
        while(n!=0){
            ++j;
         if(j==n){
        break;
        }
        if(nhanvien[j].getMaNV().equals(MaNV)){
                System.out.println("Ma nhan vien bi trung vui long nhap lai");
                MaNV = sc.nextLine();
                j=-1;
            }
        }
        nhanvien[n].setMaNV(MaNV);
        nhanvien[n].Nhap();
           ghifile();
        ++n;
    }
     void xoa(){
         docfile();
        String c = "Y";
        if(n==0){
            System.out.println("Khong co nhan vien de xoa");
            return;
        }else if(n>=0){
            ghifile2();
            while(c.equals("Y")){
            System.out.println("Nhap ma nhan vien muon xoa");
            String manv = sc.nextLine();
            for(int i=0;i<n;i++){
            if(nhanvien[i].getMaNV().equals(manv)){
                System.out.println("Tim thay nhan vien theo ma "+manv+" co thong tin nhu sau");
                System.out.println(nhanvien[i]);      
                for(int j=i;j<n-1;j++){
                nhanvien [j] = nhanvien [j+1];
                }
                n = n-2;
                System.out.println("Xoa thanh cong");
                ghifile();
                ++n;
                return;
            }
            }
            System.out.print("Khong tim thay nhan vien co ma "+manv+ " trong danh sach ban co muon nhap lai cho chinh xac?(Y/Ky tu bat ky): ");
            c = sc.nextLine();
            }
    }      
     }
    void xuat(){
        docfile();
        for(int i=0;i<n;i++){
            System.out.println("STT "+(i+1)+nhanvien[i]);
        }
    }
    void timNVtheoMa(){  
        docfile();
        String c = "Y";
        if(n==0){
            System.out.println("Khong co nhan vien trong danh sach");
            return;
        }else if(n>=0){
            while(c.equals("Y")){
            System.out.println("Nhap ma nhan vien muon tim");
            String manv = sc.nextLine();
            for(int i=0;i<n;i++){
            if(nhanvien[i].getMaNV().equals(manv)){
                System.out.println("Tim thay nhan vien theo ma "+manv+" co thong tin nhu sau");
                System.out.println(nhanvien[i]);       
                return;
            }
            }
            System.out.print("Khong tim thay nhan vien co ma "+manv+ " trong danh sach ban co muon nhap lai cho chinh xac?(Y/Ky tu bat ky): ");
            c = sc.nextLine();
            }
    }
    }
    void TimNVTheoTen(){
        docfile();
        String c = "Y";
        boolean check = false;
      if(n==0){
            System.out.println("Khong co nhan vien de tim");
            return;
        }else if(n>=0){
            while(c.equals("Y")){
        System.out.print("Nhap ten nhan vien muon tim: ");
        String TENNV = sc.nextLine();
        for(int i=0;i<n;i++){
            if(nhanvien[i].getTenNV().lastIndexOf(TENNV)>=0){
                System.out.println(nhanvien[i]);
                check = true;
            }
        }
        if(check){
        break;
        }
          System.out.println("Khong tim thay nhan vien co ten "+TENNV+" trong danh sach ban co muon nhap lai cho chinh xac?(Y/Ky tu bat ky)");
          c = sc.nextLine();
        }    
        }
    }
    NhanVien checkMANV(String MaNV){
     docfile();
     for(int i=0;i<n;i++){
     if(nhanvien[i].getMaNV().equals(MaNV)) return nhanvien[i];
     }
     return null;
    }
    void Sapxeptheoma(){
        docfile();
        NhanVien temp;
        for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
        if(nhanvien[i].getMaNV().compareTo(nhanvien[j].getMaNV()) >0){
            temp = nhanvien[i];
            nhanvien[i] = nhanvien[j];
            nhanvien[j]= temp;
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
            System.out.println("Khong co nhan vien de sua");
            return;
        }
         while(j==-1 && c.equals("Y")){
        System.out.println("Nhap ma nhan vien muon sua: ");
        String manv = sc.nextLine();
        for(int i=0;i<n;i++){
        if(nhanvien[i].getMaNV().equals(manv)){
        j = i;
        break;
        }
        }
        if(j==-1){
            System.out.println("Ma nhan vien khong ton tai ban co muon nhap lai cho chinh xac?(Y/hoac bat ky ki tu): ");
            c = sc.nextLine();
        }
        }
        if(j !=-1 ){
            int choose;
            String MaNV;
        System.out.println("=================================");
            System.out.println("Ma nhan vien-------------1");
            System.out.println("Ten nhan vien--------2");
            System.out.println("Ngay sinh------------3");
            System.out.println("Dia chi-----------------4");
            System.out.println("SDT----------------5");
            System.out.println(":Luong-----------6");
            System.out.print("Chon thong tin muon sua: ");
            choose = sc.nextInt();
            switch(choose){
                case 1:
                    sc.nextLine();
                    System.out.println("Ma nhan vien: ");
                    MaNV = sc.nextLine();
                  while(n!=0){
            ++m;
         if(m==n){
        break;
        }
        if(nhanvien[m].getMaNV().equals(MaNV)){
                System.out.println("Ma nhan vien bi trung vui long nhap lai");
                MaNV = sc.nextLine();
                m=-1;
            }
        }
                    nhanvien[j].setMaNV(MaNV);
                    
                    break;
                case 2: 
                    sc.nextLine();
                    System.out.println("Ten nhan vien: ");
                    nhanvien[j].setTenNV(sc.nextLine());
                    break;
                 case 3: 
                System.out.println("Ngay sinh: ");
                nhanvien[j].setNgaySinh(LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt()));
                break;
                 case 4: 
                     sc.nextLine();
                    System.out.println("Dia chi: ");
                    nhanvien[j].setDiaChi(sc.nextLine());
                    break;
                    case 5: 
                        sc.nextLine();
                    System.out.println("SDT: ");
                    nhanvien[j].setSDT(sc.nextLine());
                    break;
                    case 6:
                        System.out.println("Luong: ");
                       nhanvien[j].setLuong(sc.nextFloat());
                       break;
                    case 7:
                        System.out.println("Gioi tinh: ");
                        nhanvien[j].setSex(sc.nextLine());
                        break;
            }
            System.out.println("Sua hoan tat");
            ghifile();
        }        
    }
        void ghifile() {
            FileOutputStream os;
        try {
            os = new FileOutputStream("Nhanvien");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for(int i = 0 ;i<=n;i++){
            oos.writeObject(nhanvien[i]);
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
            writer = new PrintWriter("Nhanvien");
            writer.write("");
        writer.flush();
        writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DanhSachNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    void docfile(){
    n=0;
            FileInputStream is;
        try {
            is = new FileInputStream("Nhanvien");
             ObjectInputStream ois = new ObjectInputStream(is);
                 while(true){
                   Object obj = ois.readObject();
                   if(obj == null) {
                   break;
                   }
            nhanvien[n] = (NhanVien)obj;
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
//    void Thongke(){
//       docfile();
//        int choose;
//        System.out.println("Thong ke nhan vien");
//        System.out.println("Luong----1");
//        System.out.println("Bien ban vi pham---------2");
//        System.out.println("Thanh tich-------3");
//        choose = sc.nextInt();
//        switch(choose){
//            case 1 :
//                float s =0;
//                float m=-1;
//                float k = 999999;
//                int j;
//                System.out.print("Luong trung binh: ");
//                for(int i=0;i<n;i++){
//                s += nhanvien[i].getLuong();
//                if(m<nhanvien[i].getLuong()){
//                m = nhanvien[i].getLuong();
//                }
//                if(k>)
//                }
//                System.out.print(s/n);
//                System.out.println("");
//                System.out.println("Luong cao nhat: "+m);
//                System.out.println("La cac nhan vien");
//                for(int i=0;i<n;i++){
//                if(nhanvien[i].getLuong()==m){
//                    System.out.println(nhanvien[i]);
//                }
//                }
//              break;
//            case 2 :
//              break;
//            case 3 :
//                break;
//        }
//    }
}

