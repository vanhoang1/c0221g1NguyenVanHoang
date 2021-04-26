package Case_Study.controllers.dataOfFurama;

import Case_Study.models.Employee;

import java.util.*;

public class Employees extends PushPullVHR<Employee> {
    public Employees() {
        super();
       super.path=PathFurama.EMPLOYEE;
    }

    @Override
    public Employee conver(ArrayList<String> arrayList) {
        Employee employee= new Employee();
        employee.setIdEmployee(Integer.parseInt( arrayList.get(0)));
       employee.setNameEmployee( arrayList.get(1));
       employee.setAge( Integer.parseInt((arrayList.get(2))));
       employee.setAddress(arrayList.get(3));
       return employee;
    }
    public void addMap(){
        moveClone();
        Map<Integer,Employee> map = new HashMap<>();
        for (Employee e :
                clone) {
            map.put(e.getIdEmployee(), e);
        }
        Iterator<Integer> iterator= map.keySet().iterator();
        while (iterator.hasNext()){
            map.get(iterator.next()).showEmployee();
        }
    }
}
