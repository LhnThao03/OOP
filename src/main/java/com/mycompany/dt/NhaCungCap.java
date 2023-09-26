package com.mycompany.dt;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;
public class NhaCungCap implements Serializable{
    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private String SDT;
    transient Scanner sc = new Scanner(System.in);
    public NhaCungCap(){
        
    }

    public NhaCungCap(String maNCC) {
        this.maNCC = maNCC;
    }
    
    public NhaCungCap(String maNCC,String tenNCC, String diaChi, String SDT, String Fax)
    {
        this.maNCC=maNCC;
        this.tenNCC=tenNCC;
        this.diaChi=diaChi;
        this.SDT=SDT;
    }
    public NhaCungCap(NhaCungCap n)
    {
        this.maNCC=n.maNCC;
        this.tenNCC=n.tenNCC;
        this.diaChi=n.diaChi;
        this.SDT=n.SDT;

    }

    public String getMaNCC() {
        return maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSDT() {
        return SDT;
    }


    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
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
        final NhaCungCap other = (NhaCungCap) obj;
        return Objects.equals(this.maNCC, other.maNCC);
    }
      void Nhap(){
          System.out.print("Ten nha cung cap: ");
          this.tenNCC = sc.nextLine();
          System.out.print("Dia chi nha cung cap: ");
          this.diaChi = sc.nextLine();
          System.out.print("So dien thoai: ");
          this.SDT = sc.nextLine();
      }

    @Override
    public String toString() {
        return " Ma nha cung cap: " + maNCC + "| Ten nha cung cap: " + tenNCC + " Dia Chi: " + diaChi + "| SDT: " + SDT;
    }
      
}
