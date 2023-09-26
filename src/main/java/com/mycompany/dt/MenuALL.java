package com.mycompany.dt;

import com.mycompany.dt.MenuDSKH;
import com.mycompany.dt.MenuDSNCC;
import com.mycompany.dt.MenuDSNV;
import com.mycompany.dt.MenuDSPN;
import com.mycompany.dt.MenuDSSP;
import java.util.Scanner;
import java.io.IOException;

public class MenuALL {
    
    static MenuDSSP mndssp = new MenuDSSP();
    static MenuDSNV mndsnv = new MenuDSNV();
    static MenuDSKH mndskh = new MenuDSKH();
    static MenuDSPN mndspn = new MenuDSPN();
    static MenuDSHĐ mndshd = new MenuDSHĐ();
    static MenuDSNCC mndsncc = new MenuDSNCC();
    private static int choose;
    static Scanner in = new Scanner(System.in);
    public static void menu() throws IOException{
        do {
            showMenu();
            choose = Integer.valueOf(in.nextLine());
            switch(choose){
                case 1 : 
                    mndssp.menu();
                    break;
                case 2 :
                    mndshd.menu();
                    break;
                case 3 :
                    mndsnv.menu();
                    break;
                case 4 :
                    mndskh.menu();
                    break;
                case 5 :
                    mndspn.menu();
                    break;
                case 6 : 
                    mndsncc.menu();
                    break;
            }
        } while (choose!=0);
    }

    public static void showMenu(){
        System.out.println();
        System.out.println("    *********MENU_ALL********");
        System.out.println("  * |1| Danh Sach San Pham     * ");
        System.out.println(" *  |2| Danh Sach Hoa Don       *");
        System.out.println("*   |3| Danh Sach Nhan Vien       *");
        System.out.println("*   |4| Danh Sach Khach Hang      *");
        System.out.println("*   |5| Danh Sach Phieu Nhap      *");
        System.out.println(" *  |6| Danh Sach Nha Cung Cap   *");
        System.out.println("  * |0| Ket Thuc Chuong Trinh  *");
        System.out.println("    ************************* "); 
        System.out.print("<==> Chao ban, moi ban chon :  ");
    }
}
