package Case_Study.controllers;

import Case_Study.controllers.exception.*;

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

    Scanner scanner = new Scanner(System.in);

    private boolean validate(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public boolean check(int value, String input) {

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
                return validate(NUMBER, input) && Double.parseDouble(input) > 30;
            case 6:
                return input.equals("massage") || input.equals("karaoke") || input.equals("food") || input.equals("water") || input.equals("carRental");
            case 7:
                return validate(NUMBER, input) && Integer.parseInt(input) > 0;
            case 8:
                return validate(NUMBER, input) && Integer.parseInt(input) > 0 && Integer.parseInt(input) < 20;
            case 9:
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                ParsePosition position = new ParsePosition(0);
                formatter.setLenient(false);
                Date n = formatter.parse(input, position);
                if (n == null) return false;
                else {
                    Date now = new Date();
                    Calendar calendar = new GregorianCalendar();
                    calendar.setTime(n);
                    int year = calendar.get(Calendar.YEAR);
                    return (now.getTime() - n.getTime()) / 1000 / 31536000 > 18 && year > 1900;
                }
            case 10:
                return validate(NAMECUSTOMER, input);
            case 11:
                return validate(IDCARD, input);
            case 12:
                return validate(EMAIL, input);
            case 13:
                return validate(GENDER, input);
            default:
                return true;
        }

    }

    public String addNameCustomer() {
        String name;
        while (true){
        try {
            System.out.println("input name customer");
            name = scanner.nextLine();
            if (!check(10, name)) {
                throw new NameException();
            }
            break;
        }catch (NameException e){
            System.err.println(e.getMessage());
        }

        }
            return name;
    }

    public String addIdCard() {
        String id;
        while (true) {
            try {
                System.out.println("input id card :");
                id = scanner.nextLine();

                if (check(11, id))
                    break;
                {
                    throw new IdCardException();
                }
            } catch (IdCardException e) {
                System.err.println(e.getMessage());
            }
        }
        return id;
    }

    public String addDateOfBirth() {
        String date;
        while (true) {
            try {
                System.out.println("input Birth Date :");
                date = scanner.nextLine();


                if (!check(9, date)) {
                    throw new BirthdayException();

                }
                break;
            } catch (BirthdayException e) {
                System.err.println(e.getMessage());
            }

        }
        return date;
    }

    public String addEmail() {
        String email;
        while (true) {
            try {
                System.out.println("input Email :");
                email = scanner.nextLine();

                if (!check(12, email)) {
                    throw new EmailException("Email phải đúng định dạng abc@abc.abc");

                }
                break;
            } catch (EmailException e) {
                System.out.println(e.getMessage());
            }

        }


        return email;
    }

    public String addGender() {
        String gender;
        while (true) {
            try {
                System.out.println("Input gender :");
                gender = scanner.nextLine();
                gender = gender.toLowerCase();
                if (!check(13, gender)) {
                    throw new GenderException();
                }
                break;
            } catch (GenderException e) {
                System.err.println(e.getMessage());
            }
        }
        String firstLetter = gender.substring(0, 1);
        String remainingLetters = gender.substring(1, gender.length());
        firstLetter = firstLetter.toUpperCase();
        gender= firstLetter + remainingLetters;;
        return gender;
    }
    public String addCMND(){
        String cmnd;
        while (true) {
            try {
                System.out.println("Input CMND");
                cmnd = scanner.nextLine();

                if (!check(7, cmnd)) {
                    throw new Exception("chỉ nhập số dương");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        return cmnd;
    }
    public String addPhone(){
        String phone;
        while (true) {
            try {
                System.out.println("Input Phone");
                phone = scanner.nextLine();

                if (!check(7, phone)) {
                    throw new Exception("chỉ nhập số dương");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        return phone;
    }
}
