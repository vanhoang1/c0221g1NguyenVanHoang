package model.bean;

public class Employee {
    private  Integer idEmployee;
    private  String nameEmployee;
    private Integer age;
    private String address;

    public Employee(Integer idEmployee, String nameEmployee, Integer age, String address) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.age = age;
        this.address = address;
    }

    public Employee() {

    }

    @Override
    public String toString() {
        return  idEmployee +
                "," + nameEmployee +
                "," + age +
                "," + address ;
    }

    public void showEmployee(){
        System.out.println("Employee{" +
                "idEmployee=" + idEmployee +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}');
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
