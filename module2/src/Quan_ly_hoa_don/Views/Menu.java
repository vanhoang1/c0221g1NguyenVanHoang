package Quan_ly_hoa_don.Views;

import Quan_ly_hoa_don.Controllers.QuanLyKhachHang;

import java.util.Scanner;

public class Menu {
    private static QuanLyKhachHang quanLyKhachHang= new QuanLyKhachHang();
    private static Scanner scanner= new Scanner(System.in);
    public static void run() {
        int choice = 0;
        do {
            DisplayMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    themMoiKhachHang();
                    break;
                case 2:
                    hienThiThongTinKhachHang();
                    break;
                case 3:
                    timKiemKhachHang();
                    break;
                case 4:
                    themMoiHoaDon();
                    break;
                case 5:
                case 7:
                    System.exit(0);
            }
        }
        while (true);
    }

    private static void themMoiHoaDon() {

    }

    private static void timKiemKhachHang() {
    }

    private static void hienThiThongTinKhachHang() {
        quanLyKhachHang.show();
    }

    private static void themMoiKhachHang() {
        int choice;
        while (true){
            try {
                System.out.println("1. Thêm khách hàng VN,\n" +
                        " \t2. Thêm khách hàng nước ngoài, \n");
                choice= Integer.parseInt(scanner.nextLine());
                if(choice!=1&&choice!=2){
                    throw new Exception();
                }
                break;
            }catch (Exception e){
                System.err.println("chỉ chọn 1 hoặc 2");
            }
        }
        quanLyKhachHang.add(choice);
    }

    private static void DisplayMenu() {
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ HÓA ĐƠN TIỀN ĐIỆN\n" +
                "Chọn chức năng:\n" +
                "1. Thêm mới khách hàng.\n" +
                "2. Hiện thị thông tin khách hàng\n" +
                "3. Tìm kiếm khách hàng\n" +
                "4. Thêm mới hóa đơn\n" +
                "5. Chỉnh sửa hóa đơn\n" +
                "6. Hiện thị thông  tin chi tiết hóa đơn\n" +
                "7. Thoát\n");
    }
}
