package ss2_loopAndArray.BaiTap;

import java.util.Scanner;

public class BTThemPhanTu {
    public static void main(String[] args) {
        int doDai;
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập vào đọ dài của mảng");
        doDai=Integer.parseInt(scanner.nextLine());
        int[] arr = new int[doDai];
        int[] newArr= new int[doDai+1];
        for (int i=0;i<arr.length;i++){
            System.out.printf("nhập vào phần tử thứ %s của mảng ",i+1);
            arr[i]=Integer.parseInt(scanner.nextLine());
        }
        System.out.print("mảng : ");
        for (int i: arr
        ) {
            System.out.print(i+" ");

        }
        System.out.println();
        System.out.println("nhập vào phần tử cần thêm :");
        int them= Integer.parseInt(scanner.nextLine());
        System.out.println("nhập vào vị ví cần thêm: ");
        int viTri= Integer.parseInt(scanner.nextLine())-1;
        if(viTri<=1||viTri>=arr.length-1){
            System.out.println("không thể thêm!");
        }else {
            for (int i=0;i<arr.length;i++){
                if(i<viTri){
                    newArr[i]=arr[i];
                }else {
                    newArr[i+1]=arr[i];
                }
                newArr[viTri]=them;
            }
            for(int x:newArr){
                System.out.println(x+" ");
            }
        }

    }
}
