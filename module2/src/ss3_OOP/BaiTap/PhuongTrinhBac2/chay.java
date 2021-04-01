package ss3_OOP.BaiTap.PhuongTrinhBac2;

import java.util.Scanner;

public class chay {
    public static void main(String[] args) {
        System.out.println("nhập vào a :");
        Scanner scanner=new Scanner(System.in);
        double a=Double.parseDouble(scanner.nextLine());
        System.out.println("nhập vào b :");
        double b=Double.parseDouble(scanner.nextLine());
        System.out.println("nhập vào c :");
        double c=Double.parseDouble(scanner.nextLine());
        QuadraticEquation tinh= new QuadraticEquation(a,b,c);
        if(tinh.getDiscriminant()>0){
            if(tinh.getRoot1()==tinh.getRoot2()){
                System.out.println(" phương trình có 1 nghiệm là :"+tinh.getRoot1());
            }else
                System.out.printf("Phương trình có 2 nghiệm là %s và %s :",tinh.getRoot1(),tinh.getRoot2());

        }else System.out.println("The equation has no roots");
    }
}
