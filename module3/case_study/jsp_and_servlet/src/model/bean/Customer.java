package model.bean;

public class Customer implements Comparable<Customer> {
    private int id;
    private String nameCustomer;
    private String dateOfBirth;
    private String gender;
    private Integer soCMND;
    private Integer soDT;
    private String idCard;
    private String email;
    private String typeOfCustomer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Integer getSoDT() {
        return soDT;
    }

    public void setSoDT(Integer soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }


    public Customer(int id, String nameCustomer, String dateOfBirth, String gender, Integer soCMND, Integer soDT, String idCard, String email, String typeOfCustomer) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.soCMND = soCMND;
        this.soDT = soDT;
        this.idCard = idCard;
        this.email = email;
        this.typeOfCustomer = typeOfCustomer;

    }

    public Customer() {
    }



    @Override
    public int compareTo(Customer o) {
        String[] x = o.getDateOfBirth().split("/");
        int year = Integer.parseInt(x[2]);
        x = this.getDateOfBirth().split("/");
        int year2 = Integer.parseInt(x[2]);
        if (year > year2) {
            return -1;
        } else
            return 1;
    }

    public int hashCode() {
        return 31 + nameCustomer.hashCode();
    }
}
