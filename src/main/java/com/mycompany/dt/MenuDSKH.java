package com.mycompany.dt;

import java.util.Scanner;
import java.io.IOException;

public class MenuDSKH {
    DanhSachKhachHang dskh = new DanhSachKhachHang();
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
                    dskh.add();
                    System.out.println("\n[ Da them khach hang thanh cong ! ]");
                    break;
                case 2 : 
                    dskh.xoa();
                    break;
                case 3 : 
                    dskh.Sua();
                    break;
                case 4 :
                    dskh.timKHtheoMa();
                    break;
                case 5:
                    dskh.TimKHTheoTen();
                case 6 :
                    dskh.xuat();
                    break;
            }
        } while (luaChon!=0);
    }

    public  void ShowMenu(){
        System.out.print(" ==================Menu khach hang================\n"); 
        System.out.print("| ~~~1. Them khach hang                           |\n");
        System.out.print("| ~~~2. Xoa khach hang                            |\n");
        System.out.print("| ~~~3. Sua khach hang                            |\n");
        System.out.print("| ~~~4. Tim kiem khach hang theo ma               |\n");
        System.out.print("| ~~~5. Tìm kiem khach hang theo ten              |\n");
        System.out.print("| ~~~6. Xuat danh sach khach hang                 |\n");
        System.out.print("| ~~~0. Thoat chuong trinh                        |\n");
        System.out.print(" ================================================\n"); 
        System.out.print(">>> Ban chon la : ");
    }
}