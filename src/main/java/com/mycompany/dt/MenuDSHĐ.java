package com.mycompany.dt;

import java.util.Scanner;
import java.io.IOException;

public class MenuDSHĐ {
    DanhSachHoaDon dshd = new DanhSachHoaDon();
    DanhSachChiTietHoaDon dscthd = new DanhSachChiTietHoaDon();
    private int luaChon;
    Scanner in = new Scanner(System.in);
    public void menu() throws IOException{
        do {
            ShowMenuDSHĐ();
            luaChon = Integer.valueOf(in.nextLine());
            switch(luaChon){
                
            }
        } while (luaChon!=0);
    }

    public static void ShowMenuDSHĐ(){
        System.out.print(" ==================MENU-HOÁ-ĐƠN================\n");
        System.out.print("| ~~~1. Them hoa don                       |\n");
        System.out.print("| ~~~2. Xuat danh sach hoa don                 |\n");
        System.out.print("| ~~~3. Xoa                    |\n");
        System.out.print("| ~~~4.Tim kiem                    |\n");
        System.out.print("| ~~~5.Sua                    |\n");
        System.out.print("| ~~~0.Thoat                  |\n");
        System.out.print(" ==============================================\n"); 
        System.out.print(">>> Ban Chon La : ");
    }


}
