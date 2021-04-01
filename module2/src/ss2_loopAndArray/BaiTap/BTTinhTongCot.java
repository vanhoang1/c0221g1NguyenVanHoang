package ss2_loopAndArray.BaiTap;

import java.util.Scanner;

public class BTTinhTongCot {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập vào số hàng : ");
        int x=Integer.parseInt(scanner.nextLine());
        System.out.println("nhập vào số cột :");
        int y=Integer.parseInt(scanner.nextLine());
        float[][] arr= new float[x][y];
        for (int i = 0; i <x ; i++) {
            for (int j = 0; j <y ; j++) {
                System.out.printf("nhập vào phần tử hàng %d cột %d :",i+1,j+1);
                arr[i][j]=Float.parseFloat(scanner.nextLine());
            }
        }
        System.out.println("nhập vào cột cần tính :");
        int cot=Integer.parseInt(scanner.nextLine());
        float sum=0.0f;
        System.out.println("cột được chọn là :");
        for (int i = 0; i < y; i++) {
            System.out.println(arr[i][cot-1]);
            sum+=arr[i][cot-1];
        }
        System.out.println("có tổng là :"+sum);
    }
}
