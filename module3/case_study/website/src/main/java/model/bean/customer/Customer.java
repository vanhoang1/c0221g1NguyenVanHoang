package model.bean.customer;

import java.util.Date;

public class Customer {
    private int id;
    private String nameCustomer;
    private Date dateOfBirth;
    private String soCMND;
    private int gender;
    private String soDT;
    private String maKhachHang;
    private String address;
    private String email;
    private CustomerType customerType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public Customer(String nameCustomer, Date dateOfBirth, String soCMND, int gender, String soDT, String maKhachHang, String address, String email, CustomerType customerType) {
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.soCMND = soCMND;
        this.gender = gender;
        this.soDT = soDT;
        this.maKhachHang = maKhachHang;
        this.address = address;
        this.email = email;
        this.customerType = customerType;
    }

    public Customer(int id, String nameCustomer, Date dateOfBirth, String soCMND, int gender, String soDT, String maKhachHang, String address, String email, CustomerType customerType) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.soCMND = soCMND;
        this.gender = gender;
        this.soDT = soDT;
        this.maKhachHang = maKhachHang;
        this.address = address;
        this.email = email;
        this.customerType = customerType;
    }

    public Customer() {
    }

}
