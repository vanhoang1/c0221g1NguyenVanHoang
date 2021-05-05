package Case_Study_Ver2.Views;

import Case_Study_Ver2.Commons.NotFoundVehicelException;
import Case_Study_Ver2.Commons.Validate;
import Case_Study_Ver2.Commons.manipulation.OtoManipulation;
import Case_Study_Ver2.Commons.manipulation.TruckManipulation;
import Case_Study_Ver2.Models.Transport;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static OtoManipulation otoManipulation = new OtoManipulation();
    static TruckManipulation truckManipulation = new TruckManipulation();

    private static void DisplayMenu() {
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG\n" +
                "Chọn chức năng:\n" +
                "1. Thêm mới phương tiện.\n" +
                "2. Hiện thị phương tiện\n" +
                "3. Xóa phương tiện\n" +
                "4. Thoát\n");
    }

    private static void displayShowVehicle() {
        System.out.println("" +
                "1.Hiện thị xe tải.\n" +
                "2. Hiện thị ôtô. \n" +
                "3. Hiện  xe máy\n");
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
        truckManipulation.add();
    }

    private static void showVehicle() {
        displayShowVehicle();
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showTruck();
                    break;
                case 2:
                    showOto();
                    break;
                default:
                    throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("lựa chọn từ 1 đến 3");
        }
    }

    private static void showTruck() {
        truckManipulation.show();
    }

    private static void showOto() {
        otoManipulation.show();
    }

    private static void delVehicle() {
        int oto = -1;
        int truck = -1;
        int moto = -1;
        while (true) {
            try {
                System.out.println(" nhập biển số xe :");
                String input = scanner.nextLine();
                oto = otoManipulation.search(input);
                truck = truckManipulation.search(input);
                if (oto < 0 && truck < 0)
                    throw new NotFoundVehicelException("Biển kiểm soát không tồn tại");
                break;
            } catch (NotFoundVehicelException v) {
                System.out.println(v.getMessage());
            }
        }
        if (oto>=0) {
          otoManipulation. choicedel(oto);
        }
        if (truck>=0) {
         truckManipulation.choicedel(truck);
        }
    }




    public static void run() {
        int choice = 0;
        do {
            DisplayMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewVehicle();
                    break;
                case 2:
                    showVehicle();
                    break;
                case 3:
                    delVehicle();
                    break;
                case 4:
                    System.exit(0);
            }
        }
        while (true);
    }


}

