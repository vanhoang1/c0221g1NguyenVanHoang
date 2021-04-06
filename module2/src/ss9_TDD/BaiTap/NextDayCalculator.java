package ss9_TDD.BaiTap;

import java.util.Date;

public class NextDayCalculator {
    public static String inputDay(String input ){
        String[] arrDay=   input.split("/");
        int day= Integer.parseInt( arrDay[0]);
        int month= Integer.parseInt( arrDay[1]);
        int year= Integer.parseInt( arrDay[2]);
       if( checkDateFormat(day,month,year)) {

           day += 1;
           switch (month) {
               case 1:
               case 3:
               case 5:
               case 7:
               case 8:
               case 10:
               case 12: {
                   if (day > 31) {
                       month += 1;
                       if (month > 12) {
                           month = 1;
                           year += 1;
                       }


                   }
                   break;
               }
               case 4:
               case 6:
               case 9:
               case 11:
                   if (day > 30) {
                       month += 1;
                   }
                   break;
               case 2:
                   if (checkLeapYear(year)) {
                       if (day > 29) {
                           day = 1;
                           month += 1;
                       }
                   } else if (day > 28) {
                       day = 1;
                       month += 1;
                   }
                   break;
           }
           return day + "/" + month + "/" + year;
       }else return " wrong date format";
    }
    public static  boolean checkLeapYear( int year ){

        // If a year is multiple of 400,
        // then it is a leap year
        if (year % 400 == 0)
            return true;

        // Else If a year is multiple of 100,
        // then it is not a leap year
        if (year % 100 == 0)
            return false;

        // Else If a year is multiple of 4,
        // then it is a leap year
        return year % 4 == 0;
    }
    public static  boolean checkDateFormat(int day,int month,int year){
        if(day>31||day<1||month>12||month<1)return false;
        else switch (month){
            case 2:
                if(checkLeapYear(year))
                if(day>29)return false;
                else if(day>28) return  false;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(day>30)return false;
                break;
        }
        return true;
    }
}

