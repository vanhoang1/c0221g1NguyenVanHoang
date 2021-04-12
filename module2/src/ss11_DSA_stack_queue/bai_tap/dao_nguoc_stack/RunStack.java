package ss11_DSA_stack_queue.bai_tap.dao_nguoc_stack;

public class RunStack {
    public static void main(String[] args) {
        MyWStack<Integer> stackList= new MyWStack<Integer>();
        stackList.push(1);
        stackList.push(2);
        stackList.push(3);
        stackList.push(4);
        stackList.push(5);
        stackList.printStack();
        StringBuilder data= new StringBuilder();
        while (!stackList.isEmpty()){
            data.append(stackList.pop());
        }
        System.out.println(data);
    }


}
