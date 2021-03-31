package ss1_Introduction_to_java.BaiTap;

import java.util.Scanner;

public class BTHienThiLoiChao {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hello: " + name);
    }
}
