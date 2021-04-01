package ss2_loopAndArray.BaiTap;

import java.util.Scanner;

public class BTXoaPhanTu {
    public static void main(String[] args) {
        int doDai;
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập vào đọ dài của mảng");
        doDai=Integer.parseInt(scanner.nextLine());
        int[] arr = new int[doDai];
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
        System.out.println("nhập vào phần tử cần xóa :");
        int xoa= Integer.parseInt(scanner.nextLine());
        int k=check(xoa,arr);
        if(k>=0){
            if (arr.length - 1 - k >= 0) System.arraycopy(arr, k + 1, arr, k, arr.length - 1 - k);
            arr[arr.length-1]=0;
            System.out.println("mảng sau khi xóa");
            for (int i:arr){
                System.out.print(i+" ");
            }
        }else System.out.println("Không có phần tử trong mảng");


    }
    public static int check(int x,int[] array){
        for (int i=0;i<array.length;i++)
              {
                  if(array[i]==x){
                      return i ;
                  }
        }
        return -1;
    }

}
