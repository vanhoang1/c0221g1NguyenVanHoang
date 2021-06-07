package model.service.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public  final static String CUSTOMER="^KH\\-[0-9]{4}$";
    public  final static String SERVICE="^DV\\-[0-9]{4}$";
    public  final static String PHONE="^090[0-9]{7}$|^091[0-9]{7}$|^\\(84\\)\\+90[0-9]{7}$|^\\(84\\)\\+91[0-9]{7}$";
    public  final static String IDCARD="^[0-9]{9}$|^[0-9]{12}$";
    public  final static String EMAIL="^[a-z][a-z0-9_\\.]{3,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";

    private static boolean validate(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    public static  boolean checkCustomerId(String id){
        return  validate(CUSTOMER,id);
    }
    public static  boolean checkServiceId(String id){
        return  validate(SERVICE,id);
    }
    public static  boolean checkPhoneNumber(String phone){
        return  validate(PHONE,phone);
    }
    public static  boolean checkIdCard(String idCard){
        return  validate(IDCARD,idCard);
    }
    public static  boolean checkEmail(String email){
        return  validate(EMAIL,email);
    }
}
