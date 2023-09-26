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
import java.util.logging.Level;
import java.util.logging.Logger;

public class DanhSachHoaDon {
    HoaDon hd[] = new HoaDon[200];
    private int n=0;
    private int luaChon;
    Scanner in = new Scanner(System.in); 

     public boolean Xoa() throws IOException{
        docfile();
         System.out.print("Nhap ma hoa don ban muon xoa: ");
         String x = in.nextLine();
             int i;
             for(i=0; i<n; i++)
                 if(hd[i].getMaHoaDon().equals(x)) { //tìm vị trị của sinh viên trong mảng
                     break;
                 }
             if(i==n) //không tìm thấy mã sinh viên cần xoá
                 return false;
             for(int j=i; j<n-1; j++) //cập nhật lại mảng
                 hd[j] = hd[j+1];
             n--;
             return true;
     }

    public void TimKiem(){
        docfile();
        boolean timThay = false;
        int d = 0;
        System.out.print("Nhap ma san pham ban muon tim: ");
        String MaHD = String.valueOf(in.nextLine());
        for(int i=0;i<n;i++){
            if(hd[i].getMaHoaDon().equals(MaHD)){
                timThay = true;
                d = i ;
                break;
            }
        }
        if(timThay == true){
                XuatHeaderHĐ();
                hd[d].xuat();
        } 
        if(timThay == false){
                System.out.println("Khong tim thay ma hoa don!");
        }
    }

     public void find(String MaHD){
         docfile();
         boolean timThay = false;
         int d = 0;
         for(int i=0;i<n;i++){
             if(hd[i].getMaHoaDon().equals(MaHD)){
                 timThay = true;
                 d = i ;
                 break;
             }
         }
         if(timThay == true){
                 xuat();
                 hd[d].xuat();
                 for(int i = 0 ; i< 10;i++){
                     if(hd[i].getMaHoaDon().equals(MaHD))
                     hd[i].xuat();
                 }
         } 
         if(timThay == false){
                 System.out.println("Khong tim thay ma hoa don!");
         }
     }
    public void Them(){
           DanhSachNhanVien dsnv = new DanhSachNhanVien();
        dsnv.docfile();
            if(dsnv.getN()==0){
            System.out.println("Vui long bo sung nhan vien vao danh sach truoc khi tao hoa don");
            return;
        }
        docfile();
        int j =-1;
          System.out.print("Ma hoa don: ");
        String MaHD = in.nextLine();
        while(n!=0){
            ++j;
         if(j==n){
        break;
        }
        if(hd[j].getMaHoaDon().equals(MaHD)){
                System.out.print("Ma hoa don bi trung vui long nhap lai: ");
                MaHD = in.nextLine();
                j=-1;
            }
        }
        
        System.out.print("Nhap ma nhan vien: ");
        String MaNV = in.nextLine();
        String c = "No";
        while(true){
        if(dsnv.checkMANV(MaNV)!=null){
        break;
        }
            System.out.print("Khong tim thay nhan vien trong danh sach(Ban co muon xem danh sach nhan vien nhan Y/phim bat ky): ");
            c = in.nextLine();
            if(c.equals("Y")){
                dsnv.xuat();
            }
            System.out.print("Nhap lai ma nhan vien: ");
            MaNV = in.nextLine();
        }

        DanhSachKhachHang a =new DanhSachKhachHang();
        a.add();
        System.out.print("Nhap gio lap: ");
        String gioLap = in.nextLine();

        hd[n] = new HoaDon(MaHD,MaNV,a.LayMaCuoi(), gioLap);
        System.out.print("So luong san pham muon ban: ");
        int s = in.nextInt();
        for(int i=0;i<s;i++){
        hd[n].nhap();
        }
        ghifile();
        n++;
    }
    void xuat(){
        docfile();
        for(int i=0;i<n;i++){
            System.out.println("------------------Hoa don thu "+i+"----------------");
            hd[i].xuat();
        }
    }
    public void XuatHeaderHĐ() {
        System.out.println();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@ HOÁ_ĐƠN @@@@@@@@@@@@@@@@@@@@@@@@@@@\n"); 
        System.out.print("+ - - - - - - + - - - - - - - + - - - - - - - - + - - - - - - - +\n");
        System.out.print("|  Mã Hoá Đơn |  Mã Nhân Viên |  Mã Khách Hàng  |     Giờ Lập   |\n");
        System.out.print("+ - - - - - - + - - - - - - - + - - - - - - - - + - - - - - - - +\n");
    }

     public void Sua(){
         System.out.print("Nhap ma hoa don ban muon sua: ");
         String MaSP = String.valueOf(in.nextLine());
         boolean timThay = false;
         int d = 0;
         for(int i=0;i<n;i++){
             if(hd[i].getMaHoaDon().equals(MaSP)){
                 timThay = true;
                 d = i ;
                 break;
            }
         }
         if(timThay == true){
             System.out.println("=================================");
             System.out.println("Ma hoa don-------------1");
             System.out.println("Ma nhan vien--------2");
             System.out.println("Ma khach hang------------3");
             System.out.println("Gio lap-----------------4");
             System.out.print("Chon thong tin muon sua: ");
             luaChon = Integer.valueOf(in.nextLine());
            
             switch(luaChon){
                 case 1 :
                     System.out.print("Ma hoa don : ");
                     String mahd = in.nextLine();
                     hd[d].setMaHoaDon(mahd);
                     break;
                 case 2 :
                     System.out.print("Ma nhan vien: ");
                     String manv = in.nextLine();
                     hd[d].setMaNhanVien(manv);
                     break;
                 case 3 :
                     System.out.print("Ma khach hang ");
                     String makh = in.nextLine();
                     hd[d].setMaKhachHang(makh);
                     break;
                 case 4 :
                     System.out.print("Gio lap: ");
                     String giolap = in.nextLine();
                     hd[d].setGioLap(giolap);
                     break;
             }
             System.out.println("Sua thanh cong!");
         } 
         if(timThay == false){
             System.out.println("Khong tim thay hoa don!");
         }
     }

           void ghifile() {
            FileOutputStream os;
        try {
            os = new FileOutputStream("HoaDon.txt");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for(int i = 0 ;i<=n;i++){
            oos.writeObject(hd[i]);
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
            writer = new PrintWriter("HoaDon.txt");
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
            is = new FileInputStream("HoaDon.txt");
             ObjectInputStream ois = new ObjectInputStream(is);
                 while(true){
                   Object obj = ois.readObject();
                   if(obj == null) {
                   break;
                   }
            hd[n] = (HoaDon)obj;
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
    
    /// tinh tong tien hoa don theo nhan vien
   float Tongtien(String manv){
       float sum =0;
   for(int i=0;i<n;i++){
       if(hd[i].getMaNhanVien().equals(manv)){
           sum += hd[i].getTongTien();
           }
   }
   return sum;
   }
}
