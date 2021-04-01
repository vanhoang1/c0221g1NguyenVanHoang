package ss2_loopAndArray.BaiTap;

import java.util.Scanner;

public class BTDuongCheo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập chiều dài:");
        int n= Integer.parseInt(scanner.nextLine());
        float[][] arr = new float[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("nhập vào phần tử hàng %d cột %d ", i+1, j+1);
                System.out.println();
                arr[i][j] = Float.parseFloat(scanner.nextLine());
            }
        }
        float sum=0;
        for (int i = 0; i <n ; i++) {
            sum+=arr[i][i];
        }
        System.out.println("tổng đường chéo là "+sum );
    }
}
