package com.mycompany.dt;

import java.util.Scanner;
import java.io.IOException;

public class MenuDSPN {
    DanhSachPhieuNhap dspn = new DanhSachPhieuNhap();
    
    int luaChon;
    Scanner in = new Scanner(System.in);
    public void menu() throws IOException{
        do {
            System.out.println();
            ShowMenu();
            luaChon = Integer.valueOf(in.nextLine());
            System.out.println();

            switch(luaChon){
                case 1:
                    dspn.add();
                case 2:
                    dspn.xoa();
                case 3:
                    dspn.Sua();
                case 4 :
                    dspn.timPhieuNhaptheoMa();
                case 5:
                  break;
                case 6:
                    dspn.xuat();
            }
        } while (luaChon!=0);
    }

    public static void ShowMenu(){
        System.out.print(" ==================MENU PHIEU NHAP=================\n"); 
        System.out.print("| ~~~1. Them phieu nhap                            |\n");
        System.out.print("| ~~~2. Xoa phieu nhap                             |\n");
        System.out.print("| ~~~3. Sua phieu nhap                             |\n");
        System.out.print("| ~~~4. Tim kiem phieu nhap                        |\n");
        System.out.print("| ~~~5. Mua phieu nhap                             |\n");
        System.out.print("| ~~~6. Xuat danh sach phieu nhap                  |\n");
        System.out.print("| ~~~0. Thoat chuong trinh                         |\n");
        System.out.print(" =================================================\n"); 
        System.out.print(">>> Ban chon la : ");
    }
}