package model.bean.employee;

import java.util.Date;

public class Employee {
    private  int idEmployee;
    private  String nameEmployee;
    private Position position;
    private Education education;
    private Division division;
    private Date birthDay;
    private  String idCard;
    private  double salary;
    private String phone;
    private String address;
    private String email;
    private  String username;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Employee(int idEmployee, String nameEmployee, Position position, Education education, Division division, Date birthDay, String idCard, double salary, String phone, String address, String email, String username) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.position = position;
        this.education = education;
        this.division = division;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.username = username;
    }

    public Employee(String nameEmployee, Position position, Education education, Division division, Date birthDay, String idCard, double salary, String phone, String address, String email, String username) {
        this.nameEmployee = nameEmployee;
        this.position = position;
        this.education = education;
        this.division = division;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.username = username;
    }

    public Employee() {
    }
}
