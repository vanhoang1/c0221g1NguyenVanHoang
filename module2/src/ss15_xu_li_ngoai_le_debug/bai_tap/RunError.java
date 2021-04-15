package ss15_xu_li_ngoai_le_debug.bai_tap;


import java.util.Scanner;

public class RunError {
    public static void main(String[] args)  {

        System.out.println(" nhập vào 3 xanh tam giác");
        try {
            nhap3Canh();
        }catch (IllegalTriangleException e){
            System.err.println(e.getMessage());
        }

    }
    public  static void nhap3Canh()throws IllegalTriangleException{
        Scanner scanner = new Scanner(System.in);
        int  a= Integer.parseInt( scanner.nextLine());
        int b= Integer.parseInt( scanner.nextLine());
        int c= Integer.parseInt( scanner.nextLine());
        boolean checkTong=(a+b)<c||(a+c)<b||(b+c)<a;
        boolean checkAm=(a<=0||b<=0||c<=0);
        if(checkTong||checkAm){
            throw  new IllegalTriangleException(" không phải là 3 canh tam giác");
        }
        new BaCanh(a, b, c);
    }
    static class  BaCanh{
        int a;
        int b;
        int c;
        public BaCanh(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
