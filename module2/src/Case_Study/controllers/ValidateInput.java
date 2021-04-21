package Case_Study.controllers;

import Case_Study.controllers.exception.BirthdayException;
import Case_Study.controllers.exception.IdCardException;
import Case_Study.controllers.exception.NameException;
import Case_Study.controllers.exception.userException;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateInput {
    final static String ADDNEWVILLA = "^(SVVL-)[0-9]{4}$";
    final static String ADDNEWHOUSE = "^(SVHO-)[0-9]{4}$";
    final static String ADDNEWROOM = "^(SVRO-)[0-9]{4}$";
    final static String ADDNAME = "^[A-Z][^A-Z]+$";
    final static String NUMBER = "^[0-9]+$";
    final static String NAMECUSTOMER = "^[A-Z][a-z]+(\\s{1,}[\\.]{0,1}[A-Z][a-z]*)+$";
    final static String IDCARD = "^[0-9]{3}\\s{1,}[\\.]{0,1}[0-9]{3}\\s{1,}[\\.]{0,1}[0-9]{3}+$";
    final static String EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    final static String GENDER = "(male)$|(female)$|(unknow)$";

    Scanner scanner= new Scanner(System.in);

    private  boolean validate(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public  boolean check(int value, String input) {

        switch (value) {
            case 1:
                return validate(ADDNEWVILLA, input);
            case 2:
                return validate(ADDNEWHOUSE, input);

            case 3:
                return validate(ADDNEWROOM, input);

            case 4:
                return validate(ADDNAME, input);

            case 5:
                return validate(NUMBER, input)&&Double.parseDouble(input) > 30;
            case 6:
                return input.equals("massage") || input.equals("karaoke") || input.equals("food") || input.equals("water") || input.equals("carRental");
            case 7:
                return validate(NUMBER, input)&&Integer.parseInt(input)>0;
            case 8:
                return validate(NUMBER, input)&& Integer.parseInt(input)>0&&Integer.parseInt(input)<20;
            case 9:
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                ParsePosition position = new ParsePosition(0);
                formatter.setLenient(false);
                Date n= formatter.parse(input, position);
                if(n==null) return  false;
                else {
                    Date now = new Date();
                    Calendar calendar = new GregorianCalendar();
                    calendar.setTime(n);
                    int year = calendar.get(Calendar.YEAR);
                    return (now.getTime()-n.getTime())/1000/31536000>18&&year>1900;
                }
            case 10:
                return validate(NAMECUSTOMER,input);
            case 11:
                return  validate(IDCARD,input);
            case 12:
                return validate(EMAIL,input);


            default:
                return true;
        }

    }
     public    String addNameCustomer() throws NameException {
        System.out.println("input name customer");

        String input= scanner.nextLine();
        if(!check(10,input))
        {
            throw new NameException();
        }else
         return input;
    }

    public     String addIdCard() throws IdCardException {
            System.out.println("input id card :");
            String input= scanner.nextLine();

            if(!check(11,input))
            {
                throw new IdCardException();

            }else
                return input;
        }
    public String addDateOfBirth() throws BirthdayException {

        System.out.println("input Birth Date :");
        String input= scanner.nextLine();


        if(!check(9,input))
        {
            throw new BirthdayException();

        }else
            return input;
    }
    public String addEmail() throws userException {
        System.out.println("input Email :");
        String input= scanner.nextLine();

        if(!check(12,input))
        {
            throw new userException("Email phải đúng định dạng abc@abc.abc");

        }else
            return input;
    }
}
