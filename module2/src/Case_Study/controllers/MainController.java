package Case_Study.controllers;

import Case_Study.controllers.dataOfFurama.Houses;
import Case_Study.controllers.dataOfFurama.Rooms;
import Case_Study.controllers.dataOfFurama.Villas;
import Case_Study.controllers.exception.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MainController<E> {
    static Scanner scanner = new Scanner(System.in);
    static Villas villas = new Villas();
    static Houses houses = new Houses();
    static Rooms rooms = new Rooms();
    static ValidateInput validateInput = new ValidateInput();
    static boolean check = true;

    public static void displayMainMenu() {
        System.out.println("" +
                "1.\t Add New Services\n" +
                "2.\tShow Services\n" +
                "3.\tAdd New Customer\n" +
                "4.\tShow Information of Customer\n" +
                "5.\tAdd New Booking\n" +
                "6.\tShow Information of Employee\n" +
                "7.\tExit\n");
    }

    public static void info() {
        int choice;
        do {
            displayMainMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewServies();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addNewCustomer();

                case 7:
                    System.exit(0);
                    break;
            }
        } while (true);

    }

    private static void addNewCustomer() {
        String idCus = null;
        String nameCus = null;
        String dateOfBirth = null;
        String gender = null;
        Integer soCMND = null;
        Integer SDT = null;
        String Email = null;
        String typeOfCustomer = null;
        check = true;
        while (check) {
            try {
                if (idCus == null) {
                    idCus = validateInput.addIdCard();
                }
                if (nameCus == null) {
                    nameCus = validateInput.addNameCustomer();
                }
                if (dateOfBirth == null) {
                    dateOfBirth = validateInput.addDateOfBirth();
                }


                gender = scanner.nextLine();
                System.out.println("input CMND :");
                soCMND = Integer.parseInt(scanner.nextLine());
                System.out.println("input So dien thoai :");
                soCMND = Integer.parseInt(scanner.nextLine());

                check = false;
            } catch (NameException  | IdCardException | BirthdayException e) {
                System.err.println(e.getMessage());

            } finally {
                System.out.println(dateOfBirth);
            }

        }
    }
    public static void addNewServies() {
        System.out.println(
                "1.\tAdd New Villa\n" +
                        "2.\tAdd New House\n" +
                        "3.\tAdd New Room\n" +
                        "4.\tBack to menu\n" +
                        "5.\tExit\n");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                info();
                break;
            case 5:
                System.exit(5);
                break;
        }
    }

    private static ArrayList<String> vip(int i) {
        ArrayList<String> arrayList = service(i);
        System.out.println("Enter Standard Room:");
        String tc = scanner.nextLine();
        System.out.println("Enter a Description of another facility:");
        String tn = scanner.nextLine();
        System.out.println("Enter the Floor Number:");
        String st = scanner.nextLine();
        arrayList.add(tc);
        arrayList.add(tn);
        arrayList.add(st);
        return arrayList;
    }

    public static void addNewVilla() {
        ArrayList<String> villa = vip(1);
        System.out.println("Enter the Pool Area :");
        String dt = scanner.nextLine();
        villa.add(dt);
        villas.push(villa);
    }

    public static void addNewHouse() {
        ArrayList<String> house = vip(2);
        houses.push(house);
    }

    public static void addNewRoom() {
        ArrayList<String> room = service(3);
        System.out.println("input Free Service :");
        String freeService = scanner.nextLine();
        room.add(freeService);
        rooms.push(room);
    }

    public static ArrayList<String> service(int i) {

        ArrayList<String> arrayList = new ArrayList<>();
        String id;
        do {
            System.out.println("Input id :");
            id = scanner.nextLine();
            check = validateInput.check(i, id);
            if (!check)
                System.err.println("wrong");
        } while (!check);
        String ns;
        do {
            System.out.println("Name of service :");
            ns = scanner.nextLine();
            check = validateInput.check(4, ns);
            if (!check)
                System.err.println("wrong");
        } while (!check);
        String as;
        do {
            System.out.println("Area used:");
            as = scanner.nextLine();
            check = validateInput.check(5, as);
            if (!check)
                System.err.println("wrong");
        } while (!check);
        String r;
        do {
            System.out.println("Rent:");
            r = scanner.nextLine();
            check = validateInput.check(7, r);
            if (!check)
                System.err.println("wrong");
        } while (!check);
        String mp;
        do {
            System.out.println("Maximum number of people :");
            mp = scanner.nextLine();
            check = validateInput.check(8, mp);
            if (!check)
                System.err.println("wrong");
        } while (!check);
        System.out.println("Rent type :");
        String rt = scanner.nextLine();
        arrayList.add(id);
        arrayList.add(ns);
        arrayList.add(as);
        arrayList.add(r);
        arrayList.add(mp);
        arrayList.add(rt);
        return arrayList;
    }

    public static void showServices() {
        System.out.println("" +
                "1.\tShow all Villa\n" +
                "2.\tShow all House\n" +
                "3.\tShow all Room\n" +
                "4.\tShow All Name Villa Not Duplicate\n" +
                "5.\tShow All Name House Not Duplicate\n" +
                "6.\tShow All Name Name Not Duplicate\n" +
                "7.\tBack to menu\n" +
                "8.\tExit\n");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                showAllVilla();
                break;
            case 2:
                showAllHouse();
                break;
            case 3:
                showAllRoom();
                break;
            case 4:
                showAllNameVillaNotDuplicate();
                break;
            case 5:
                showAllNameHouseNotDuplicate();
                break;
            case 6:
                showAllNameRoomNotDuplicate();
                break;
            case 7:
                info();
                break;
            case 8:
                System.exit(0);
                break;
        }

    }

    public static void showAllVilla() {
        villas.showVilas();
    }

    public static void showAllHouse() {
        houses.showHouses();
    }

    public static void showAllRoom() {
        rooms.showRooms();
    }

    public static void showAllNameHouseNotDuplicate() {

    }

    public static void showAllNameVillaNotDuplicate() {

    }

    public static void showAllNameRoomNotDuplicate() {

    }

    public static void main(String[] args) {

        MainController.info();
    }

}
