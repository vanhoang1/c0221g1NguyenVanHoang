package ss10_DSA.BaiTap.trienkhaiLinkerArray;


public class MyLinkedList<E> {
    private Node<E> head;
    private int numNode = 0;

    static class Node<E> {
        private Node<E> next;
        private E data;

        public Node(E data) {
            this.data = data;
        }


        public Node<E> getNext() {
            return next;
        }

        public E getData() {
            return data;
        }
    }

    public MyLinkedList() {
    }

    public void add(int index, E e) {
        if (index == 0) {
            head = new Node<E>(e);
            return;
        }
        Node<E> temp = head;
        Node<E> holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node<E>(e);
        temp.next.next = holder;
        numNode++;
    }

    public void addFirst(E e) {
        Node<E> temp = head;
        head = new Node<E>(e);
        head.next = temp;
        numNode++;
    }

    public void addLast(E e) {
        Node<E> temp = head;
        Node<E> holder;
        for (int i = 0; i < numNode; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node<E>(e);
        temp.next.next = holder;
        numNode++;
    }

    public E remove(int index) {

        if (index > numNode) {
            return null;
        }
        Node<E> temp = head;
        if (index == 0) {
            head = temp.next;
            return temp.getData();
        }
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node<E> holder = temp.next;
        temp.next = temp.next.next;
        return holder.getData();

    }

    public boolean remove(Object e) {
        Node<E> temp = head;
        if (temp.getData() == e) {
            head = temp.next;
            return true;
        }
        while (temp != null) {
            if (temp.next.getData().equals(e)) {
                temp.next = temp.next.next;
                numNode--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void printList() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public E get(int i) {
        Node<E> temp = head;
        for (int j = 0; j < i; j++) {
            temp = temp.next;
        }
        return temp.getData();
    }

    public int size() {
        return numNode;
    }

    public boolean contains(E e) {
        Node<E> temp = head;
        while (temp != null) {
            if (temp.getData().equals(e)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public int indexOf(E e){
        int count=0;
        Node<E> temp = head;
        while (temp!=null){
            if(temp.getData().equals(e)){
                return count;
            }
            temp=temp.next;
            count++;
        }
        return -1;
    }
    public MyLinkedList<E> clone(){
        Node<E> temp= head;
        MyLinkedList<E> newList= new MyLinkedList<E>();
        for (int i=0;i<size();i++){
            newList.add(i,temp.getData());
            temp=temp.next;
        }
        return newList;
    }
}
