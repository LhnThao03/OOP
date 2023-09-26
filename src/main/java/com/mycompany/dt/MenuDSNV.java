package com.mycompany.dt;

import java.util.Scanner;
import java.io.IOException;

public class MenuDSNV {
    DanhSachNhanVien dsnv = new DanhSachNhanVien();
    private int luaChon;
    Scanner in = new Scanner(System.in);
    public void menu() throws IOException{
        do {
            ShowMenuDSHĐ();
            luaChon = Integer.valueOf(in.nextLine());
            switch(luaChon){
                case 1 : 
                    dsnv.add();
                    break;
                case 2 :
                 dsnv.xoa();
                    break;
                case 3:
                    dsnv.Sua();
                    break;
                case 4:
                    dsnv.timNVtheoMa();;
                    break;
                case 5:
                    dsnv.TimNVTheoTen();
                    break;
                case 6 :
                    dsnv.xuat();
                    break;
            }
        } while (luaChon!=0);
    }

    public static void ShowMenuDSHĐ(){
         System.out.print(" ==================Menu nha cung cap================\n"); 
        System.out.print("| ~~~1. Them nhan vien                          |\n");
        System.out.print("| ~~~2. Xoa                              |\n");
        System.out.print("| ~~~3. Sua                               |\n");
        System.out.print("| ~~~4. Tim kiem nhan vien theo ma                 |\n");
        System.out.print("| ~~~5. Tìm kiem nhan vien theo ten                |\n");
        System.out.print("| ~~~6. Xuat danh sach nhan vien                   |\n");
        System.out.print("| ~~~0. Thoat chuong trinh                          |\n");
        System.out.print(" ==================================================\n"); 
        System.out.print(">>> Ban chon la : ");
    }
}
