package Case_Study.controllers.dataOfFurama;

import Case_Study.models.Customer;
import Case_Study.models.Services;

import java.util.*;

public class Customers extends PushPullVHR<Customer> {
    ArrayList<Customer> booking;
    public Customers() {
        super();
        super.path=PathFurama.CUSTOMERS;
         booking= new ArrayList<>();
    }

    @Override
    public Customer conver(ArrayList<String> arrayList) {
        Customer customer = new Customer();
        customer.setIdCard(arrayList.get(0));
        customer.setNameCustomer(arrayList.get(1));
        customer.setDateOfBirth(arrayList.get(2));
        customer.setGender(arrayList.get(3));
        customer.setSoCMND(Integer.parseInt(arrayList.get(4)));
        customer.setSDT(Integer.parseInt(arrayList.get(5)));
        customer.setEmail(arrayList.get(6));
        customer.setTypeOfCustomer(arrayList.get(7));
        if(arrayList.size()==18){
          Villas villas = new Villas();
          customer.setServices( villas.conver( cat(arrayList)));
        }
        if(arrayList.size()==17){
            Houses houses= new Houses();
            customer.setServices(houses.conver(cat(arrayList)));
        }
        if (arrayList.size()==15){
            Rooms rooms= new Rooms();
            customer.setServices(rooms.conver(cat(arrayList)));
        }
        return  customer;
    }
    public ArrayList<String> cat(ArrayList<String> arrayList){
        ArrayList<String> arrayList1 = new ArrayList<>();
        for (int i = 8; i <arrayList.size() ; i++) {
            arrayList1.add(arrayList.get(i));
        }
        return arrayList1;
    }

    public void showCustomer(){
        if(clone.size()==0){
            moveClone();
        }

        Collections.sort(clone);
        clone.sort((o1, o2) -> o1.getNameCustomer().compareTo(o2.getNameCustomer()));
        showClone();
    }
    private void showClone(){
        for (Customer x :
                clone) {
            x.showInformationCustomers();
        }
    }
    public void booking(int index, Services services){
        clone.get(index).setServices(services);
        push();
        booking.add( clone.get(index) );

       ReadWrite<Customer> readWrite= new ReadWrite<>();
       readWrite.write(booking,PathFurama.BOOKING);


    }
    public Customer cinema4D(int index){
      return  clone.remove(index);
    }

}
