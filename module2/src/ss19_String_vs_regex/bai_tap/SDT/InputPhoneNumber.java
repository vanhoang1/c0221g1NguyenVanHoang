package ss19_String_vs_regex.bai_tap.SDT;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputPhoneNumber {
   final static String Phone="^[(]\\d{2}[)][-][(][0]\\d++[)]$";

    public static void main(String[] args) {
        System.out.println("input number");
        Scanner scanner =new Scanner(System.in);
        Pattern pattern =Pattern.compile(Phone);
        Matcher matcher = pattern.matcher(scanner.nextLine());
        System.out.println(matcher.matches());
    }
}
