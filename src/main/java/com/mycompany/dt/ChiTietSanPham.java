package com.mycompany.dt;
import java.util.Scanner;
import java.io.Serializable;
public class ChiTietSanPham implements Serializable{
    private int baoHanh ;
    private String mauSac;
    private String IMEI;
    private String manHinh;
    private String ram;
    private String rom;
    private int pin;
    private String thietKe;
    private String camera;
    private String xuatXu;
    private float khoiLuong;
transient Scanner sc = new Scanner(System.in);
    public ChiTietSanPham() {
    }

    public ChiTietSanPham( int baoHanh, String mauSac, String IMEI, String manHinh,String ram,String rom, int pin,String thietKe,String camera,String xuatXu,float khoiLuong) {
        this.baoHanh = baoHanh;
        this.mauSac=mauSac;
        this.IMEI=IMEI;
        this.manHinh=manHinh;
        this.ram=ram;
        this.rom=rom;
        this.pin=pin;
        this.thietKe=thietKe;
        this.camera=camera;
        this.xuatXu=xuatXu;
        this.khoiLuong=khoiLuong;
    }

    public int getBaoHanh() {
        return baoHanh;
    }

    public String getMauSac() {
        return mauSac;
    }

    public String getIMEI() {
        return IMEI;
    }

    public String getManHinh(){
        return manHinh;
    }

    public String getRam(){
        return ram;
    }

    public String getRom(){
        return rom;
    }

    public int getPin(){
        return pin;
    }
    
    public String getThietKe(){
        return thietKe;
    }

    public String getCamera(){
        return camera;
    }

    public String getXuatXu(){
        return xuatXu;
    }
    
    public float getKhoiLuong(){
        return khoiLuong;
    }
    public void setBaoHanh(int baoHanh) {
        this.baoHanh = baoHanh;
    }

    public void setMauSac(String mauSac) {
        this.mauSac =mauSac;
    }

    public void setIMEI(String IMEI) {
        this.IMEI= IMEI;
    }

    public void setManHinh(String manHinh) {
        this.manHinh= manHinh;
    }

    public void setRam(String ram) {
        this.ram= ram;
    }

    public void setRom(String rom) {
        this.rom= rom;
    }

    public void setPin(int pin) {
        this.pin= pin;
    }

    public void setThietKe(String thietKe) {
        this.thietKe= thietKe;
    }
    public void setCamera(String camera) {
        this.camera= camera;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu=xuatXu ;
    }

    public void setKhoiLuong(float khoiLuong) {
        this.khoiLuong= khoiLuong;
    }

 void nhap(){
         String a1="";
          int a2=0;
         float a3=0;
         while(a1.equals("")){
        System.out.print("Man hinh: ");
        a1 = sc.nextLine();
         }
        setManHinh(a1);
        a1="";
         while(a1.equals("")){
        System.out.print("Camera: ");
         a1 = sc.nextLine();
         }
        setCamera(a1);
        a1="";
        while(a1.equals("")){
          System.out.print("Mau sac:  ");
          a1 = sc.nextLine();
        }
        setMauSac(a1);
        a1="";
        while(a1.equals("")){
          System.out.print("Ram: ");
          a1 = sc.nextLine();
        }
        setRam(a1);
        a1 = "";
         while(a1.equals("")){
          System.out.print("Rom: ");
         a1 = sc.nextLine();
         }
         setRom(a1);
         a1 = "";
         while(a1.equals("")){
          System.out.print("Thiet ke: ");
           a1 = sc.nextLine();
         }
        setThietKe(a1);
        a1="";
        while(a1.equals("")){
          System.out.print("Xuat xu: ");
          a1 = sc.nextLine();
        }
        setXuatXu(a1);
        a1 = "";
        while(a2<=0){
          System.out.print("Pin: ");
          a2 = sc.nextInt();
        }
        setPin(a2);
        a2 = 0;
        while(a3<=0){
          System.out.print("Khoi luong: ");
          a3 = sc.nextFloat();
        }
        setKhoiLuong(a3);
        while(a2<=0){
          System.out.print("Bao hanh: ");
          a2 = sc.nextInt();
        }
        setBaoHanh(a2);
        sc.nextLine();
        while(a1.equals("")){
          System.out.print("IMEI: ");
          a1 = sc.nextLine();
        }
        setIMEI(a1);
    }
void sua(){
     String a1="";
          int a2=0;
         float a3=0;
         Scanner sc = new Scanner(System.in);
        System.out.println("Man hinh-------------1");
            System.out.println("Camera--------2");
            System.out.println("Mau sac------------3");
            System.out.println("Ram-----------------4");
            System.out.println("Rom----------------5");
            System.out.println("Thiet ke-----------------6");
            System.out.println("Xuat xu----------------7");
            System.out.println("Pin-----------------8");
            System.out.println("Khoi luong----------------9");
            System.out.println("Bao hanh-----------------10");
            System.out.println("IMEI----------------11");
        System.out.print("Nhap lua chon: ");
        int c = sc.nextInt();
    switch(c){
        case 1:
            sc.nextLine();
         while(a1.equals("")){
        System.out.print("Man hinh: ");
        a1 = sc.nextLine();
         }
        setManHinh(a1);
        a1="";
        break;
        case 2: 
            sc.nextLine();
         while(a1.equals("")){
        System.out.print("Camera: ");
         a1 = sc.nextLine();
         }
        setCamera(a1);
        a1="";
        break;
        case 3:
            sc.nextLine();
        while(a1.equals("")){
          System.out.print("Mau sac:  ");
          a1 = sc.nextLine();
        }
        setMauSac(a1);
        a1="";
        break;
        case 4:
            sc.nextLine();
        while(a1.equals("")){
          System.out.print("Ram: ");
          a1 = sc.nextLine();
        }
        setRam(a1);
        a1 = "";
        break;
        case 5:
            sc.nextLine();
         while(a1.equals("")){
          System.out.print("Rom: ");
         a1 = sc.nextLine();
         }
         setRom(a1);
         a1 = "";
         break;
        case 6:
            sc.nextLine();
         while(a1.equals("")){
          System.out.print("Thiet ke: ");
           a1 = sc.nextLine();
         }
        setThietKe(a1);
        a1="";
        break;
        case 7:
            sc.nextLine();
        while(a1.equals("")){
          System.out.print("Xuat xu: ");
          a1 = sc.nextLine();
        }
        setXuatXu(a1);
        a1 = "";
        break;
        case 8:
        while(a2<=0){
          System.out.print("Pin: ");
          a2 = sc.nextInt();
        }
        setPin(a2);
        a2 = 0;
        break;
        case 9:
        while(a3<=0){
          System.out.print("Khoi luong: ");
          a3 = sc.nextFloat();
        }
        setKhoiLuong(a3);
        break;
        case 10:
        while(a2<=0){
          System.out.print("Bao hanh: ");
          a2 = sc.nextInt();
        }
        setBaoHanh(a2);
        break;
        case 11:
            sc.nextLine();
        while(a1.equals("")){
          System.out.print("IMEI: ");
          a1 = sc.nextLine();
        }
        setIMEI(a1);
        break;
    }
}
    @Override
    public String toString() {
        return "Bao hanh: " + baoHanh + "| Mau sac: " + mauSac + "|  IMEI: " + IMEI + "| Man hinh: " + manHinh + "| Ram: " + ram + "| Rom: " + rom + "| Pin: " + pin + "| Thiet ke: " + thietKe + "| Camera: " + camera + "| Xuat xu: " + xuatXu + "| Khoi luong: " + khoiLuong;
    }

}