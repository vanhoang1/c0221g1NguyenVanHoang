package ss10_DSA.BaiTap.trienkhaiLinkerArray;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> arrLink = new MyLinkedList<Integer>();
        arrLink.add(0, 7);
        arrLink.add(1, 8);
        arrLink.add(2, 9);
        arrLink.add(4, 0);
        arrLink.addLast(55);
        arrLink.addFirst(55);
        arrLink.printList();
        System.out.println("-------");
        System.out.println("Xóa phần tử:" + (arrLink.remove(arrLink.get(0))));
//        System.out.println("Xóa phần tử:"+(arrLink.remove(2)));
        arrLink.printList();
        System.out.println("7 có trong chuỗi ? :"+arrLink.contains(7));
        System.out.println("10 có trong chuỗi ? :"+arrLink.contains(10));
        System.out.println("số 8 ở vị trí :"+arrLink.indexOf(8));
       MyLinkedList<Integer> newArr= arrLink.clone();
       newArr.printList();
    }
}
