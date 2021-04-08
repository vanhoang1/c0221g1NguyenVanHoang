package ss10_DSA.BaiTap.trienkhaiArrayList;

import java.util.Arrays;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList= new MyList<Integer>(5);
        myList.add(0,1);
        myList.add(1,2);
        myList.add(2,3);
        myList.add(3,4);
        myList.add(4,5);
        myList.add(6);
        System.out.println("Array List:");
        System.out.println(Arrays.toString(myList.getElement()));
        int del=4;
        System.out.println("Array List after remove index : " +del +" value: "+myList.remove(del));

        System.out.println(Arrays.toString(myList.getElement()));
    }
}
