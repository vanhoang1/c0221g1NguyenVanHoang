package Quan_ly_hoa_don.Commons;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public  final static String KHVN="^KHVN-[0-9]{5}$";
    public  final static String KHNN="^KHNN-[0-9]{5}$";

    static Scanner scanner = new Scanner(System.in);

    private static boolean validate(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    public static boolean checkKHVN(String string){
        return validate(KHVN,string);
    }
    public static boolean checkKHNN(String string){
        return validate(KHNN,string);
    }
}
