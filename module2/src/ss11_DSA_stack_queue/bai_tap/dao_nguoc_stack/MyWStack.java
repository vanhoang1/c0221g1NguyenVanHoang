package ss11_DSA_stack_queue.bai_tap.dao_nguoc_stack;

import java.util.ArrayList;
import java.util.Arrays;

public class MyWStack<E> {
    private ArrayList<E> stack;


    public MyWStack() {
        stack = new ArrayList<E>();
    }

    public void push(E element) {
        stack.add(element);
    }
    public E pop(){
        E temp=stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return  temp;
    }
    public int size(){
        return stack.size();
    }
    public boolean isEmpty() {
        return stack.size() == 0;
    }
    public void printStack(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
        }
        System.out.println( Arrays.toString( stack.toArray()));
    }
}