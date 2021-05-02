package Case_Study_Ver2.Views;

import Case_Study_Ver2.Commons.Validate;
import Case_Study_Ver2.Commons.manipulation.OtoManipulation;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static OtoManipulation otoManipulation = new OtoManipulation();

    private static void DisplayMenu() {
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG\n" +
                "Chọn chức năng:\n" +
                "1. Thêm mới phương tiện.\n" +
                "2. Hiện thị phương tiện\n" +
                "3. Xóa phương tiện\n" +
                "4. Thoát\n");
    }

    private static void displayNewVehicle() {
        System.out.println("" +
                "1. Thêm xe tải,\n" +
                "2. Thêm ôtô, \n" +
                "3. Thêm  xe máy.\n");
    }

    private static void addNewVehicle() {
        displayNewVehicle();
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewTruck();
                    break;
                case 2:
                    addNewOto();
                    break;
                default:
                    throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("lựa chọn từ 1 đến 3");
        }
    }

    private static void addNewOto() {
        otoManipulation.add();
    }

    private static void addNewTruck() {

    }

    public static void run() {
        int choice = 0;
        do {
            DisplayMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Menu.addNewVehicle();
                    break;
                case 2:

            }
        }
        while (choice != 0);
    }
}

