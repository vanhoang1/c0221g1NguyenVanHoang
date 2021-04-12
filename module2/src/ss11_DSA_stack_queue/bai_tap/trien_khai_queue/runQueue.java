package ss11_DSA_stack_queue.bai_tap.trien_khai_queue;

public class runQueue {
    public static void main(String[] args) {
        Queue<Integer> queue= new Queue<Integer>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        System.out.println( queue.printQueue());
        queue.deQueue();
        System.out.println(queue.printQueue());
        queue.enQueue(1);
        System.out.println(queue.printQueue());
    }
}
