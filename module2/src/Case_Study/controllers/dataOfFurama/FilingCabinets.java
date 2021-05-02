package Case_Study.controllers.dataOfFurama;

import Case_Study.models.Employee;

import java.util.ArrayList;
import java.util.Stack;

public class FilingCabinets {
    private  Stack<Employee> stack;

    public FilingCabinets() {
        this.stack= new Stack<>();
    }
    public void addHoSo(ArrayList<Employee> arrayList){
        while (!arrayList.isEmpty()){
            stack.push(arrayList.remove(0));
        }
    }
    public Employee seachName(String name){
       while (!stack.isEmpty()){
           if(stack.peek().getNameEmployee().equals(name)){
               return stack.pop();
           }
           stack.pop();
       }
       return null;
    }
}
