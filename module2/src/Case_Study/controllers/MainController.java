package Case_Study.controllers;

import Case_Study.controllers.dataOfFurama.*;
import Case_Study.controllers.exception.*;
import Case_Study.models.Customer;
import Case_Study.models.Services;
import Case_Study.models.Villa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainController<E> {
    static Scanner scanner = new Scanner(System.in);
    static Villas villas = new Villas();
    static Houses houses = new Houses();
    static Rooms rooms = new Rooms();
    static Customers customers = new Customers();
    static Employees employees = new Employees();
    static ValidateInput validateInput = new ValidateInput();
    static  FilingCabinets filingCabinets= new FilingCabinets();
    static boolean check = true;

    public static void displayMainMenu() {
        System.out.println("" +
                "1.\t Add New Services\n" +
                "2.\tShow Services\n" +
                "3.\tAdd New Customer\n" +
                "4.\tShow Information of Customer\n" +
                "5.\tAdd New Booking\n" +
                "6.\tShow Information of Employee\n" +
                "7.\t4D cinema\n"+
                "8.\tFiling cabinets\n"+
                "9.\tExit\n");
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
                    break;
                case 4:
                    showcustomer();
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showInformationOfEmployee();
                    break;
                case 7:
                    cinema4D();
                    break;
                case 8:
                    filingCabinets();
                case 9:
                    System.exit(0);
                    break;
            }
        } while (true);

    }

    private static void filingCabinets() {

    }

    private static void cinema4D() {

        Queue<Customer> queue= new LinkedList<Customer>();
        int choice;
        while (true) {
            showcustomer();
            System.out.println(" choice costumer in to cinema (choice 0 :Exit) :");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > customers.size()) {
                    throw new Exception("sai");
                }
                queue.add(customers.cinema4D(choice-1));
                if(choice==0||customers.size()==0)break;
            } catch (Exception e) {
                System.out.println("nhạp sai");
            }
        }
        while (!queue.isEmpty()){
            queue.poll().showInformationCustomers();
        }
    }

    private static void showInformationOfEmployee() {
        employees.addMap();
    }

    private static void addNewBooking() {
        showcustomer();
        int choiceCus = 0;
      while (true){
          try{
              System.out.println("Choice Customer :");
               choiceCus=Integer.parseInt( scanner.nextLine());
              if(choiceCus>customers.size()||choiceCus<0){
                  throw new Exception("custormer sai!");
              }
                break;
          }catch (Exception e){
              System.err.println(e.getMessage());
          }

      }
        customers.booking(choiceCus-1,choiceService());


    }
    static Services choiceService(){
        Services e = null;
        System.out.println("" +
                "1.\tBooking Villa\n" +
                "2.\tBooking House\n" +
                "3.\tBooking Room\n");
        int choice = Integer.parseInt(scanner.nextLine());
        try {
            switch ( choice){
                case 1:
                    showAllVilla();
                    System.out.println("choice Villa :");
                    int villa=Integer.parseInt(scanner.nextLine());
                    e=villas.choiceService(villa-1);
                    break;
                case 2:
                    showAllHouse();;
                    System.out.println("choice Houses");
                    int house=Integer.parseInt(scanner.nextLine());
                    e=houses.choiceService(house-1);
                    break;
                case 3:
                    showAllRoom();;
                    System.out.println("choice Houses");
                    int room=Integer.parseInt(scanner.nextLine());
                    e=rooms.choiceService(room-1);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }catch (IllegalStateException m){
            System.out.println(m.getMessage());
        }

       return e;
    }

    private static void addNewCustomer() {
        String idCus = null;
        String nameCus = null;
        String dateOfBirth = null;
        String gender = null;
        String soCMND = null;
        String SDT = null;
        String Email = null;
        String typeOfCustomer = null;
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            idCus = validateInput.addIdCard();
            nameCus = validateInput.addNameCustomer();
            dateOfBirth = validateInput.addDateOfBirth();
            gender = validateInput.addGender();
            soCMND = validateInput.addCMND();
            SDT = validateInput.addPhone();
            Email = validateInput.addEmail();
            System.out.println("type");
            typeOfCustomer = scanner.nextLine();
        } catch (Exception e) {
            System.err.println(e.getMessage());

        }

        arrayList.add(idCus);
        arrayList.add(nameCus);
        arrayList.add(dateOfBirth);
        arrayList.add(gender);
        arrayList.add(soCMND);
        arrayList.add(SDT);
        arrayList.add(Email);
        arrayList.add(typeOfCustomer);
        customers.push(arrayList);
    }

    private static void showcustomer() {
        customers.showCustomer();
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
        String st;
        while (true) {
            try {
                System.out.println("Enter the Floor Number:");
                st = scanner.nextLine();
                if (validateInput.check(7, st)) {
                    throw new userException("phai nhap so dương");
                }
                break;
            } catch (userException e) {
                System.err.println(e.getMessage());
            }
        }

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
        houses.showAllNameNotDuplicate();
    }

    public static void showAllNameVillaNotDuplicate() {
        villas.showAllNameNotDuplicate();
    }

    public static void showAllNameRoomNotDuplicate() {
        rooms.showAllNameNotDuplicate();
    }

    public static void main(String[] args) {

        MainController.info();
    }

}
