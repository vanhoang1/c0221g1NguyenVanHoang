package ss1_Introduction_to_java.BaiTap;

import java.util.Scanner;

public class BTDoitienTe {
    public static void main(String[] args) {
        int rate=23000;
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập vào USD:");
        int usd=scanner.nextInt();
        System.out.println("Sang VND là:\n"+usd*rate);
    }
}
