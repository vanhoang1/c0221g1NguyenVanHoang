package ss11_DSA_stack_queue.bai_tap.kiem_tra_dau_Stack;

import java.util.Stack;

public class RunKiemTraDau {
    public static void main(String[] args) {
        String[] arr= ("(a+b)*a-c*(b-d)").split("");
        Stack<String> stack= new Stack<String>();
        boolean check=true;
        for (String x :
                arr) {
            if(x.equals("(")){
                stack.push(x);
            }
            if(x.equals(")")){
                if (stack.isEmpty()){
                    check=false;
                    break;
                }
               stack.pop();
            }
        }
        if(!stack.isEmpty()){
            check=false;
        }
        System.out.println(check);
    }
}
