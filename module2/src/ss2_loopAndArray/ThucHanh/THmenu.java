package ss2_loopAndArray.ThucHanh;

import java.util.Scanner;

public class THmenu {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        while(true) {

            System.out.println("Menu");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
           int  choice= Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Draw the triangle");
                    for (int i=0;i<5;i++){
                        for (int j=0;j<5;j++){
                            if(i+j<5){
                                System.out.print("*");
                            }

                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("Draw the square");
                    for (int i=0;i<5;i++){
                        for (int j=0;j<5;j++){
                                System.out.print("*");

                        }
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    for (int i=0;i<3;i++){
                        for (int j=0;j<5;j++){
                            System.out.print("*");

                        }
                        System.out.print("\n");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }

        }
    }
}