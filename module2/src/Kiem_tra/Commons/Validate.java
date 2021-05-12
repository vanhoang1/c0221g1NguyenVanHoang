package Kiem_tra.Commons;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

  final static String Phone="^[0-9]{10}$";
  final static String Email="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

  Scanner scanner = new Scanner(System.in);

  private static boolean validate(String regex, String input) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);
    return matcher.matches();
  }
  public  static  boolean CheckPhone(String input){
    return validate(Phone,input);
  }
  public  static  boolean CheckEmail(String input){
    return validate(Email,input);
  }

}
