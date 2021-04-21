package ss19_String_vs_regex.bai_tap.name_class;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameClass {
    private static final String NAMECLASS_REGEX = "^[A|B|C][\\w\\d]{4}[G|H|I|K|L|M]$";

    public static void main(String[] args) {
        System.out.println("input name");
        Scanner scanner =new Scanner(System.in);
        Pattern pattern =Pattern.compile(NAMECLASS_REGEX);
        Matcher matcher = pattern.matcher(scanner.nextLine());
        System.out.println(matcher.matches());
    }
}
