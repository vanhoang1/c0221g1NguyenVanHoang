package Case_Study_Ver2.Commons;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

  public  final static String BIENXETAI="^[0-9]{2}C-[0-9]{3}\\.[0-9]{2}+$";
  public  final static String BIENOTO="^[0-9]{2}[AB]-[0-9]{3}\\.[0-9]{2}+$";
  public  final static String BIENXEMAY="^[0-9]{2}-[A-Z][0-9A-Z]-[0-9]{3}\\.[0-9]{2}+$";

  Scanner scanner = new Scanner(System.in);

  private static boolean validate(String regex, String input) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);
    return matcher.matches();
  }
  public  static  boolean CheckBienXeTai(String input){
    return validate(BIENXETAI,input);
  }
  public  static  boolean CheckBienXeOto(String input){
    return validate(BIENOTO,input);
  }
  public  static  boolean CheckNumBer(String input,int min, int max){
    String NUMBER="";
    if(max>9){
      NUMBER="^["+min+"-9][0-9]*$";
    }
    else {
      NUMBER="^["+min+"-"+max+"]$";
    }
    return validate(NUMBER,input);
  }
}
