package ss2_loopAndArray.BaiTap;

import java.util.Scanner;

public class BTTimMin {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("nhập vào kích thước mảng :");
        int size=Integer.parseInt(scanner.nextLine());
        int[] arr=new int[size];
        for (int i=0;i<arr.length;i++){
            System.out.println("nhâp vào phần tử thứ "+i+1);
            arr[i]=Integer.parseInt(scanner.nextLine());
        }
        int min=arr[0];
        for (int x:
            arr ) {
            if(x<min){
                min=x;
            }
        }
        System.out.println("phần tử nhỏ nhất là :"+ min);
    }
}
