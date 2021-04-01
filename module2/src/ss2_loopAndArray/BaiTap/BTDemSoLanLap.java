package ss2_loopAndArray.BaiTap;

import java.util.Scanner;

public class BTDemSoLanLap {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập vào 1 chuỗi");
        String chuoi=scanner.nextLine();
        System.out.println("nhập vào kí tự cần kiểm tra: ");
        String kiTu= scanner.nextLine();
        int coutn=0;
        String[] a= chuoi.split("");
        for (String s : a) {
            if (s.equals(kiTu)) {
                coutn++;
            }

        }
        System.out.println("số lần xuất hiện là :");
        System.out.println(coutn);
    }


}
