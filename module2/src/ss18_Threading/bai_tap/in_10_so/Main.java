package ss18_Threading.bai_tap.in_10_so;

public class Main {


    public static void main(String[] args) {
        NumberGenerator newNum =new NumberGenerator();
        NumberGenerator newNum2 =new NumberGenerator();
        Thread thread= new Thread(newNum);
        Thread thread2= new Thread(newNum2);
        thread.start();
        thread2.start();
    }
}
