package model.bean;

import java.util.Date;

public class Customer {
    private int id;
    private String nameCustomer;
    private Date dateOfBirth;
    private String soCMND;
    private String soDT;
    private String address;
    private String email;
    private int typeOfCustomer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(int typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(int id, String nameCustomer, Date dateOfBirth, String soCMND, String soDT, String address, String email, int typeOfCustomer) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.soCMND = soCMND;
        this.soDT = soDT;
        this.address = address;
        this.email = email;
        this.typeOfCustomer = typeOfCustomer;
    }

    public Customer(String nameCustomer, Date dateOfBirth, String soCMND, String soDT, String address, String email, int typeOfCustomer) {
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.soCMND = soCMND;
        this.soDT = soDT;
        this.address = address;
        this.email = email;
        this.typeOfCustomer = typeOfCustomer;
    }

    public Customer() {
    }

}
