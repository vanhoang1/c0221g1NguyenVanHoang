package Case_Study_Ver2.Commons.manipulation;

import Case_Study_Ver2.Commons.CsvToString;

import java.util.List;

public interface Manipulation<E> {

   void add();
    E edit(E e);
   void del(int index);
   int search(String bs);

}
