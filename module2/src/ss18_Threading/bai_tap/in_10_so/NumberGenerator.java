package ss18_Threading.bai_tap.in_10_so;

public class NumberGenerator implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i <11 ; i++) {
            try {
                System.out.println(hashCode());
                System.out.println(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
