package ss2_loopAndArray.BaiTap;

import java.util.Scanner;

public class BTHienThiHinh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Draw the rectangle");
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 5; j++) {
                            System.out.print("*");

                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("Draw the triangle");
                    System.out.println("1. top-left");
                    System.out.println("2. top-right");
                    System.out.println("3. bottom-left");
                    System.out.println("4. bottom-right");
                    int triangle = Integer.parseInt(input.nextLine());
                    switch (triangle) {
                        case 1:
                            for (int i = 0; i < 6; i++) {
                                for (int j = 0; j < 6; j++) {
                                    if (i + j < 5) {
                                        System.out.print("*");
                                    }
                                }
                                System.out.print("\n");
                            }
                            break;
                        case 2:
                            for (int i = 0; i < 6; i++) {
                                for (int j = 0; j < 6; j++) {
                                    if (j < i) {
                                        System.out.print(" ");
                                    } else
                                        System.out.print("*");

                                }
                                System.out.print("\n");
                            }
                            break;
                        case 3:
                            for (int i = 0; i < 6; i++) {
                                for (int j = 0; j < 6; j++) {
                                    if (j<=i) {
                                        System.out.print("*");
                                    } else
                                        System.out.print(" ");

                                }
                                System.out.print("\n");
                            }
                            break;
                        case 4:
                            for (int i = 0; i < 6; i++) {
                                for (int j = 0; j < 6; j++) {
                                    if (i + j < 5) {
                                        System.out.print(" ");
                                    } else {
                                        System.out.print("*");
                                    }
                                }
                                System.out.print("\n");
                            }
                            break;
                    }
                    break;
                case 3:
                    int giua=6;
                    System.out.println("Draw the rectangle");
                    for (int i=0;i<6;i++){
                        for(int j=0;j<13;j++) {
                            if (j+i>=7&&j-7<=i) {
                                System.out.print("*");
                            } else
                                System.out.print(" ");
                        }
                        System.out.println("\n");
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

