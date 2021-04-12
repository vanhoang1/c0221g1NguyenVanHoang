package ss11_DSA_stack_queue.bai_tap.trien_khai_queue;



public class Queue<E>  {
  private   Node fornt;
  private   Node rear;
  private  int size=0;
    public Queue() {
        this.fornt = null;
        this.rear = null;
    }

    public void  enQueue(int key) {
        Node temp = new Node(key);
        if(fornt==null){
            this.fornt=this.rear=temp;
            this.fornt.link=temp;
            this.rear.link=this.fornt;
            size++;
            return;
        }
        this.rear.link=temp;
        this.rear=temp;
        temp.link=fornt;
        size++;
    }
    public void deQueue(){
        if(fornt==null){
            return ;
        }
        if(fornt==rear){
          this.fornt=this.rear=null;
        }else {
           this.fornt = this.fornt.link;
            this.rear.link= this.fornt;
        }
        size--;
    }
    public String printQueue(){
       StringBuilder data= new StringBuilder();
        Node temp = this.fornt;
       for (int i=0;i<size;i++){
            data.append(temp.data).append(" ");
            temp=temp.link;
        }
        return data.toString();
    }
}
