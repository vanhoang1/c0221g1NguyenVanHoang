package Case_Study.controllers;

import Case_Study.controllers.dataOfFurama.Houses;
import Case_Study.controllers.dataOfFurama.PathFurama;
import Case_Study.controllers.dataOfFurama.Rooms;
import Case_Study.controllers.dataOfFurama.Villas;
import Case_Study.models.House;
import Case_Study.models.Room;
import Case_Study.models.Vip;

import java.util.ArrayList;
import java.util.Scanner;

public class MainController<E> {
   static Scanner scanner =new Scanner(System.in);
   static  Villas villas = new Villas();
   static Houses houses=new Houses();
   static Rooms rooms=new Rooms();

    public static void displayMainMenu(){
        System.out.println("" +
                "1.\t Add New Services\n" +
                "2.\tShow Services\n" +
                "3.\tAdd New Customer\n" +
                "4.\tShow Information of Customer\n" +
                "5.\tAdd New Booking\n" +
                "6.\tShow Information of Employee\n" +
                "7.\tExit\n");
    }
    public static void info(){
        int choice;
        do {
            displayMainMenu();
            choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addNewServies();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }while (true);

    }
    public static void addNewServies(){
        System.out.println(
                "1.\tAdd New Villa\n" +
                "2.\tAdd New House\n" +
                "3.\tAdd New Room\n" +
                "4.\tBack to menu\n" +
                "5.\tExit\n");
        int choice=Integer.parseInt(scanner.nextLine());
        switch (choice){
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
    private static ArrayList<String> vip(){
        ArrayList<String> arrayList= new ArrayList<>();
        System.out.println("Nhập id :");
        String id =scanner.nextLine();
        System.out.println("Nhập Tiêu chuẩn phòng :");
        String tc=scanner.nextLine();
        System.out.println("Nhập Mô tả tiện nghi khác :");
        String tn=scanner.nextLine();
        System.out.println("Nhập Diện Số tầng :");
        String st= scanner.nextLine();
        arrayList.add(id);
        arrayList.add(tc);
        arrayList.add(tn);
        arrayList.add(st);
        return  arrayList;
    }
    public static void addNewVilla()  {
        ArrayList<String> villa=vip();
        System.out.println("Nhập Diện tích hồ bơi :");
        String dt= scanner.nextLine();
        villa.add(dt);
        villas.push(villa);
    }
    public static  void addNewHouse(){
        ArrayList<String> house=vip();
        houses.push(house);
    }
    public  static  void  addNewRoom(){
        System.out.println(" input id :");
        String id= scanner.nextLine();
        System.out.println("input Free Service :");
        String freeService=scanner.nextLine();
        ArrayList<String> room=new ArrayList<>();
        room.add(id);
        room.add(freeService);
        rooms.push(room);
    }


    public static void main(String[] args) {
        MainController.info();
    }

}
