package com.mycompany.dt;

import java.util.Scanner;
import java.io.IOException;

public class MenuDSNCC {
    DanhSachNhaCungCap dsncc = new DanhSachNhaCungCap();
    int luaChon;
    Scanner in = new Scanner(System.in);
    public void menu() throws IOException{
        do {
            System.out.println();
            ShowMenu();
            luaChon = Integer.valueOf(in.nextLine());
            System.out.println();

            switch(luaChon){
                case 1 :
                    dsncc.add();
                    System.out.println("\n[ Da them khach hang thanh cong ! ]");
                    break;
                case 2 : 
                    dsncc.xoa();
                    break;
                case 3 : 
                    dsncc.Sua();
                    break;
                case 4 :
                    dsncc.timNCCtheoMa();
                    break;
                case 5:
                    dsncc.TimNCCTheoTen();
                    break;
                case 6 :
                    dsncc.xuat();
                    break;
            }
        } while (luaChon!=0);
    }

    // Cai nay tao chua sua cai chuc nang ben trong nha Tan
    public  void ShowMenu(){
        System.out.print(" ==================Menu nha cung cap================\n"); 
        System.out.print("| ~~~1. Them khach hang                             |\n");
        System.out.print("| ~~~2. Xoa khach hang                              |\n");
        System.out.print("| ~~~3. Sua khach hang                              |\n");
        System.out.print("| ~~~4. Tim kiem nha cung cap theo ma                 |\n");
        System.out.print("| ~~~5. Tìm kiem nha cung cap theo ten                |\n");
        System.out.print("| ~~~6. Xuat danh sach nha cung cap                   |\n");
        System.out.print("| ~~~0. Thoat chuong trinh                          |\n");
        System.out.print(" ==================================================\n"); 
        System.out.print(">>> Ban chon la : ");
    }
}
