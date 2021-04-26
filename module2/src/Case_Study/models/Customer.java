package Case_Study.models;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Customer implements Comparable<Customer> {
    private  String idCard;
   private String nameCustomer;
   private String dateOfBirth;
   private String gender;
   private Integer soCMND;
   private Integer SDT;
   private String Email;
   private String typeOfCustomer;
   private Services services;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(Integer soCMND) {
        this.soCMND = soCMND;
    }

    public Integer getSDT() {
        return SDT;
    }

    public void setSDT(Integer SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Customer(String idCard, String nameCustomer, String dateOfBirth, String gender, Integer soCMND, Integer SDT, String email, String typeOfCustomer) {
        this.idCard = idCard;
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.soCMND = soCMND;
        this.SDT = SDT;
        Email = email;
        this.typeOfCustomer = typeOfCustomer;
    }

    public Customer() {
    }

    public void showInformationCustomers()  {
        System.out.println( "Customer{" +
                "idCard='" + idCard + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", soCMND=" + soCMND +
                ", SDT=" + SDT +
                ", Email='" + Email + '\'' +
                ", typeOfCustomer='" + typeOfCustomer + '\'' +
                ", services=" + services +
                '}');
    }

    @Override
    public String toString() {
        return  idCard +
                "," + nameCustomer +
                "," + dateOfBirth +
                "," + gender +
                "," + soCMND +
                "," + SDT +
                "," + Email +
                "," + typeOfCustomer +
                "," + services ;
    }

    @Override
    public int compareTo(Customer o) {
       String[] x= o.getDateOfBirth().split("/");
       int year=Integer.parseInt( x[2]);
       x= this.getDateOfBirth().split("/");
        int year2=Integer.parseInt( x[2]);
       if(year>year2){
           return -1;
       }else
           return 1;
    }
    public int hashCode() {
        return 31 + nameCustomer.hashCode();
    }
}
