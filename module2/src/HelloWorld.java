import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class HelloWorld{
    public static void main(String[] args) {

        Scanner scanner= new Scanner("21/4/2003");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        ParsePosition position = new ParsePosition(0);
        formatter.setLenient(false);
        Date n= formatter.parse(scanner.next(), position);
        if(n==null) System.out.println(  false);
        else {
            Date now = new Date();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(n);
            int year = calendar.get(Calendar.YEAR);
            boolean x=(now.getTime()-n.getTime())/1000/31536000>=18&&year>1900;
            System.out.println(x );
        }
    }
}
