package Kiem_tra.Views;

import Kiem_tra.Commons.QuanLyDanhBa;
import Kiem_tra.Models.DanhBa;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static QuanLyDanhBa quanLyDanhBa= new QuanLyDanhBa();
    private static void DisplayMenu() {
        System.out.println("CHƯƠNG TRÌNH QUẢN LY DANH BẠ\n" +
                "Chọn chức năng theo sô (để tiếp tục):\n" +
                "1. Xem danh sách.\n" +
                "2. Thêm mới x.\n" +
                "3. Cập nhật\n" +
                "4. Xóa x\n" +
                "5. Tìm kiếm\n "+
                "6. Đọc từ file\n "+
                "7. Ghi từ file\n "+
                "8. Thoat\n "+
                "Chọn chức năng :\n ");
    }

    public static void run() {
        int choice = 0;
        do {
            DisplayMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                   xemDanhSach();
                    break;
                case 2:
                   themMoiDanhBa();
                    break;
                case 3:
                    capNhap();
                    break;
                case 4:
                    xoaDanhBa();
                    break;
                case 5:
                    timkiem();
                    break;
                case 6:
                    docfile();
                    break;
                case 7:
                    ghiFile();
                    break;
                case 8:
                    System.exit(0);

            }
        }
        while (true);
    }

    private static void ghiFile() {
        List<DanhBa> list=quanLyDanhBa.pullList();
        Scanner scanner = new Scanner(System.in);
        for (DanhBa d :
                list) {
            System.out.println(d.toString());
        }
        System.out.println("bạn có muốn ghi :\n" +
                "1. yes \n" +
                "2.no \n");
        int string=Integer.parseInt(scanner.nextLine());
        if(string==1){
        quanLyDanhBa.setList(quanLyDanhBa.pullList());
        quanLyDanhBa.pushList();
        }
    }

    private static void docfile() {
       quanLyDanhBa.hienThi();
    }

    private static void timkiem() {

      quanLyDanhBa.timGanDung();
    }

    private static void xoaDanhBa() {
        quanLyDanhBa.xoa();
    }

    private static void capNhap() {
        quanLyDanhBa.sua();
    }

    private static void themMoiDanhBa() {
        quanLyDanhBa.them();
    }

    private static void xemDanhSach() {
        quanLyDanhBa.hienThi();

    }


}

