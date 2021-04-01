package ss2_loopAndArray.BaiTap;

import java.util.Scanner;

public class BTTimMax2Chieu {
    public static void main(String[] args) {

        float[][] arr = new float[3][3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("nhập vào phần tử hàng %d cột %d ", i+1, j+1);
                System.out.println();
                arr[i][j] = Float.parseFloat(scanner.nextLine());
            }
        }
        float max = arr[0][0];
        int x = 0, y = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    x = i;
                    y = j;
                }
            }
            System.out.println();
        }
        System.out.printf("phần tử lớn nhất là %5.2f có vị trí là hàng %d cột %d", max, x+1, y+1);
    }
}
