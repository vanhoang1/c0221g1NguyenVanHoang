package Case_Study.Commons;


public class mains {
  static ServicesCommons servicesCommons= new ServicesCommons();

    public static void main(String[] args) {
        servicesCommons.pull();
        servicesCommons.showVilla();
        servicesCommons.showHouse();
    }
}
