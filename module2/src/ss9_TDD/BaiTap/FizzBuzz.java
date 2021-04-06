package ss9_TDD.BaiTap;

public class FizzBuzz {
    public static String stringFizzBuzz(int number){
        String result="";

        if(number%3==0){
            result+="Fizz";
        }
        if(number%5==0){
            result+="Buzz";
        }
        result+=checkInside(number);
        if(result.isEmpty()){
            return numberToString(number);
        }
        else
        return result;
    }
    public static String checkInside(int number){
        String check="";
        if(number/10>0){
            if(number/10==3||number%10==3){
                check+="Fizz";
            }
            if(number/10==5||number%10==5){
                check+="Buzz";
            }
        }

        return check;
    }
    public  static String numberToString(int number){
       String stringNumber="";
        switch (number/10){
            case 1:
                stringNumber += "Một";
                break;
            case 2:
                stringNumber += "Hai";
                break;
            case 3:
                stringNumber += "Ba";
                break;
            case 4:
                stringNumber += "Bốn";
                break;
            case 5:
                stringNumber += "Năm";
                break;
            case 6:
                stringNumber += "Sáu";
                break;
            case 7:
                stringNumber += "Bảy";
                break;
            case 8:
                stringNumber += "Tám";
                break;
            case 9:
                stringNumber += "Chín";
                break;
            default:
                stringNumber += "";
        }
        stringNumber += " ";
        int unit = number % 10;
        switch (unit){
           case 1:
               stringNumber += "Một";
               break;
           case 2:
               stringNumber += "Hai";
               break;
           case 3:
               stringNumber += "Ba";
               break;
           case 4:
               stringNumber += "Bốn";
               break;
           case 5:
               stringNumber += "Năm";
               break;
           case 6:
               stringNumber += "Sáu";
               break;
           case 7:
               stringNumber += "Bảy";
               break;
           case 8:
               stringNumber += "Tám";
               break;
           case 9:
               stringNumber += "Chín";
               break;
           default:
               stringNumber += "";

       }

        return  stringNumber;

        }
    }

