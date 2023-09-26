package com.mycompany.dt;

import java.util.Scanner;
import java.io.IOException;

public class MenuDSSP {
    DanhSachSanPham dssp = new DanhSachSanPham();
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
                 dssp.add();
                    break;
                case 2 : 
                    dssp.xoa();
                    break;
                case 3 : 
                    dssp.Sua();
                    break;
                case 4 :
                    dssp.timSPtheoMa();
                    break;
                case 5 : 
                    dssp.mua();
                    break;
                case 6 :
                   dssp.xuat();
                    break;
                case 7 :
                    dssp.xuatSPIOS();
                    break;
                case 8:
                    dssp.xuatSPAndroid();
                    break; 
                case 9: 
                    dssp.ThongKe();
            }
        } while (luaChon!=0);
    }
    
    public static void ShowMenu(){
        System.out.print(" ==================MENU-SAN-PHAM=================\n"); 
        System.out.print("| ~~~1. Them san pham                            |\n");
        System.out.print("| ~~~2. Xoa san pham                             |\n");
        System.out.print("| ~~~3. Sua san pham                             |\n");
        System.out.print("| ~~~4. Tim kiem san phan                        |\n");
        System.out.print("| ~~~5. Mua san pham                             |\n");
        System.out.print("| ~~~6. Xuat danh sach san pham                  |\n");
        System.out.print("| ~~~7. Xuat danh sach san pham IOS              |\n");
        System.out.print("| ~~~8. Xuat danh sach san pham Android          |\n");
        System.out.print("| ~~~9. Thong ke                                 |\n");
        System.out.print("| ~~~0. Thoat chuong trinh                       |\n");
        System.out.print(" ================================================\n"); 
        System.out.print(">>> Ban chon la : ");
    }
}