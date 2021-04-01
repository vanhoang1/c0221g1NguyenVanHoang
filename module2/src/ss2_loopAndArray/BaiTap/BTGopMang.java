package ss2_loopAndArray.BaiTap;

import java.util.Scanner;

public class BTGopMang {
    public static void main(String[] args) {
        int[] arr1=new int[5];
        int[] arr2=new int[5];
        Scanner scanner= new Scanner(System.in);
        int[] newArr= new int[10];
        for (int i = 0; i <5 ; i++) {
            System.out.println("nhập vào phần tử thứ "+i+"của mảng 1");
            arr1[i]=Integer.parseInt(scanner.nextLine());
        }
        for (int i = 0; i <5 ; i++) {
            System.out.println("nhập vào phần tử thứ "+i+"của mảng 2");
            arr2[i]=Integer.parseInt(scanner.nextLine());
        }
        System.arraycopy(arr1, 0, newArr, 0, arr1.length);
        System.arraycopy(arr2, 0, newArr, arr1.length, arr2.length);
        System.out.println("mang mới là :");
        for (int x:newArr
             ) {
            System.out.print(x+" ");
        }
    }



}
