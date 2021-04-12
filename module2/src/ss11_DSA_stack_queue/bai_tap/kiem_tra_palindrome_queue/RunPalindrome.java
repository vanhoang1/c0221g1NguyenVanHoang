package ss11_DSA_stack_queue.bai_tap.kiem_tra_palindrome_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RunPalindrome {

    public static void main(String[] args) {
        String[] arr= ("aaasssbssasaaa").split("");
        Stack<String> stack= new Stack<String>();
        Queue<String>  queue= new LinkedList<String>();

        for (String x :
                arr) {
            stack.push(x);
            queue.add(x);
        }
        boolean check=true;
        while (!stack.isEmpty()){
            if(!stack.pop().equals(queue.remove())){
                check=false;
            }
        }
        System.out.println(check);
    }
}
