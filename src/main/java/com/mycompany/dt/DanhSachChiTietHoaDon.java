package com.mycompany.dt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DanhSachChiTietHoaDon {
    ChiTietHoaDon cthd[] = new ChiTietHoaDon[200];
    private int n;

    public void Them(String tenSanPham, int soLuong, int donGia, int conLai){
        docFile();
        cthd[n] = new ChiTietHoaDon(tenSanPham, soLuong, donGia, conLai);
        n++;
    }

    public void Them(String maHoaDon,String tenSanPham, int soLuong, int donGia, int conLai,int tongTien) throws IOException{
        docFile();
        cthd[n] = new ChiTietHoaDon(maHoaDon,tenSanPham, soLuong, donGia, conLai,tongTien);
        n++;
        ghiFile();
    }

    void ghiFile() throws IOException{
        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("FileChiTietHoaDon.txt"));
        for(int i=0;i<n;i++){
            cthd[i].ghiFile();
        }
        outputStream.close();
    }

    // Xuat file ra man hinh
    void xuatFile(){
        int i=0;
        try{
            DataInputStream inStream = new DataInputStream(new FileInputStream("FileChiTietHoaDon.txt"));
            try{
                while(true){
                    String maHoaDon = inStream.readUTF();
                    String tenSanPham = inStream.readUTF();
                    int soLuong = inStream.readInt();
                    int donGia = inStream.readInt();
                    int conLai = inStream.readInt();
                    int tongTien = inStream.readInt();
                    cthd[i]=new ChiTietHoaDon(maHoaDon,tenSanPham, soLuong, donGia,conLai,tongTien);
                    cthd[i].XuatBody1();
                    i++;
                }
            }catch(EOFException e){}
            finally{
                n=i;
                inStream.close();
            }
        }catch(IOException e){}
    }

    // Doc file de lay du lieu
    void docFile(){
        int i=0;
        try{
            DataInputStream inStream = new DataInputStream(new FileInputStream("FileChiTietHoaDon.txt"));
            try{
                while(true){
                    String maHoaDon = inStream.readUTF();
                    String tenSanPham = inStream.readUTF();
                    int soLuong = inStream.readInt();
                    int donGia = inStream.readInt();
                    int conLai = inStream.readInt();
                    int tongTien = inStream.readInt();
                    cthd[i]=new ChiTietHoaDon(maHoaDon,tenSanPham, soLuong, donGia,conLai,tongTien);
                    i++;
                }
            }catch(EOFException e){}
            finally{
                n=i;
                inStream.close();
            }
        }catch(IOException e){}
    }
}
