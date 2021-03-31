package ss1_Introduction_to_java.BaiTap;

import java.util.Scanner;

public class BTDocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số :");
        int n = scanner.nextInt();
        if (n < 10 && n >= 0) {
            switch (n) {
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
                default:
                    System.out.println("out of ability");
            }
        }
        if (n < 20 && n >= 10) {
            switch (n % 10) {
                case 0:
                    System.out.println("Ten");
                    break;
                case 1:
                    System.out.println("Eleven");
                    break;
                case 2:
                    System.out.println("Twelve");
                    break;
                case 3:
                    System.out.println("Thirteen");
                    break;
                case 4:
                    System.out.println("Fourteen");
                    break;
                case 5:
                    System.out.println("Fifteen");
                    break;
                case 6:
                    System.out.println("Sixteen");
                    break;
                case 7:
                    System.out.println("Seventeen");
                    break;
                case 8:
                    System.out.println("Eighteen");
                    break;
                case 9:
                    System.out.println("Nineteen");
                    break;

            }

        }
        String dozens = "", unit = "", hundred = "";
        if (n > 20 && n < 100) {
            switch (n / 10) {
                case 2:
                    dozens = "Twenty";
                    break;
                case 3:
                    dozens = "Thirty";
                    break;
                case 4:
                    dozens = "Forty";
                    break;
                case 5:
                    dozens = "Fifty";
                    break;
                case 6:
                    dozens = "Sixty";
                    break;
                case 7:
                    dozens = "Seventy";
                    break;
                case 8:
                    dozens = "Eighty";
                    break;
                case 9:
                    dozens = "Ninety";
                    break;
            }
            switch (n % 10) {
                case 1:
                    unit = "One";
                    break;
                case 2:
                    unit = "Two";
                    break;
                case 3:
                    unit = "Three";
                    break;
                case 4:
                    unit = "Four";
                    break;
                case 5:
                    unit = "Five";
                    break;
                case 6:
                    unit = "Six";
                    break;
                case 7:
                    unit = "Seven";
                    break;
                case 8:
                    unit = "Eight";
                    break;
                case 9:
                    unit = "Nine";
                    break;
                default:
                    unit = "";
            }
            System.out.println(dozens + "-" + unit);

        }
        if (n >= 100) {
            switch ((n / 10) % 10) {
                case 1:
                    switch (n % 100 % 10) {
                        case 0:
                            dozens = "Ten";
                            break;
                        case 1:
                            dozens = "Eleven";
                            break;
                        case 2:
                            dozens = "Twelve";
                            break;
                        case 3:
                            dozens = "Thirteen";
                            break;
                        case 4:
                            dozens = "Fourteen";
                            break;
                        case 5:
                            dozens = "Fifteen";
                            break;
                        case 6:
                            dozens = "Sixteen";
                            break;
                        case 7:
                            dozens = "Seventeen";
                            break;
                        case 8:
                            dozens = "Eighteen";
                            break;
                        case 9:
                            dozens = "Nineteen";
                            break;

                    }
                    break;
                case 2:
                    dozens = "Twenty";
                    break;
                case 3:
                    dozens = "Thirty";
                    break;
                case 4:
                    dozens = "Forty";
                    break;
                case 5:
                    dozens = "Fifty";
                    break;
                case 6:
                    dozens = "Sixty";
                    break;
                case 7:
                    dozens = "Seventy";
                    break;
                case 8:
                    dozens = "Eighty";
                    break;
                case 9:
                    dozens = "Ninety";
                    break;
            }
            if (n % 100 > 20||n%100<10) {
                switch (n % 100 % 10) {
                    case 1:
                        unit = "One";
                        break;
                    case 2:
                        unit = "Two";
                        break;
                    case 3:
                        unit = "Three";
                        break;
                    case 4:
                        unit = "Four";
                        break;
                    case 5:
                        unit = "Five";
                        break;
                    case 6:
                        unit = "Six";
                        break;
                    case 7:
                        unit = "Seven";
                        break;
                    case 8:
                        unit = "Eight";
                        break;
                    case 9:
                        unit = "Nine";
                        break;
                    default:
                        unit = "";
                }
            } else unit = "";
            switch (n / 100) {
                case 1:
                    hundred = "One";
                    break;
                case 2:
                    hundred = "Two";
                    break;
                case 3:
                    hundred = "Three";
                    break;
                case 4:
                    hundred = "Four";
                    break;
                case 5:
                    hundred = "Five";
                    break;
                case 6:
                    hundred = "Six";
                    break;
                case 7:
                    hundred = "Seven";
                    break;
                case 8:
                    hundred = "Eight";
                    break;
                case 9:
                    hundred = "Nine";
                    break;
                default:
                    hundred = "";
            }
            System.out.printf("%s hundred and %s %s", hundred, dozens, unit);
        }
    }
}
