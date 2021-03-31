package ss2_loopAndArray.ThucHanh;

import java.util.Scanner;

public class THTinhTienLai {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interset_rate = 1.0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter investment amount: ");
        money = Double.parseDouble(input.nextLine());
        System.out.println("Enter number of months: ");
        month = Integer.parseInt(input.nextLine());
        System.out.println("Enter annual interest rate in percentage: ");
        interset_rate = Double.parseDouble(input.nextLine());
        double total_interset = 0;
        for(int i = 0; i < month; i++){
            total_interset += money * (interset_rate/100)/12 * month;

        }
        System.out.println("Total of interset: " + total_interset);

    }
}
