package ss2_loopAndArray.BaiTap;

import java.util.Scanner;

public class BTHienThiSoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập vào số lượng cần in");
        int input=Integer.parseInt(scanner.nextLine());
        int count=0;
        int dem=2;
        while (count<input){
            boolean check = true;
            for(int i=2;i<dem;i++){
                if (dem % i == 0) {
                    check = false;
                    break;
                }

            }
            if(check){
                System.out.println(dem);
                count++;
            }
            dem++;

        }

    }
}
