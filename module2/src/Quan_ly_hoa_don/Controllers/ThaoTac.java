package Quan_ly_hoa_don.Controllers;

public interface ThaoTac<E> {

   void add(int index);
    E edit(E e);
   void del(int index);
    E search(String value);
    void show();
}
