package ss10_DSA.BaiTap.trienkhaiArrayList;

public class MyList<E>  {
    private int size=0;
    private static final int DEFAULT_CAPACITY=10;
    private Object[] element;

    public MyList() {
        element=new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity){
        element=new Object[capacity];
    }
    public void add(int index ,E element){
        ensureCapacity(index);

        if (size - index >= 0) System.arraycopy(this.element, index, this.element, index + 1, size - index);

            this.element[index] = element;

        size++;
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
    }
    public E remove(int index){
        checkIndex(index);
        E removeE = (E) element[index];
        for (int i=index;i<element.length;i++){
            this.element[index]=this.element[index+1];
        }
        element[size-1]=null;
        size--;
        return removeE;
    }
    public int size(){
        return  this.size;
    }
    public E[] clone(){
        E[] newData = (E[]) (new Object[size]);
            System.arraycopy(element, 0, newData, 0, size);
            return  newData;
    }
    public boolean contains( E o){
        for (Object x :
                element) {
            if(o.equals(x)) return true;
        }
        return  false;
    }
    public  int indexOf(E o){
        for (int i=0;i<size;i++){
            if(o.equals(element[i])) {
                return i ;
            }
        }
        return -1;
    }
    private void ensureCapacity(int minCapacity) {
        if (size >= element.length||minCapacity>size) {
            E[] newData = (E[]) (new Object[minCapacity<=size?size:minCapacity]);
            System.arraycopy(element, 0, newData, 0, size);
            element = newData;
        }
    }
    public  void add( E o){
        ensureCapacity(size+1);
       element[size]=o;
       size++;
    }
    public  void clear(){
        for (int i=0;i<size;i++){
            element[i]=null;
        }
    }

    public Object[] getElement() {
        return element;
    }
}
