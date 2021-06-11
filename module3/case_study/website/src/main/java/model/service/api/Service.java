package model.service.api;

import java.util.List;
import java.util.Map;

public interface Service<E> {
    List<E> findAll();
    Map<String,String> save(E e) ;
    E findById(int id);
    Map<String,String> update(int id, E e) ;
    boolean  remove(int id);
    List<E> findByName(String search);
    Map<String,String>  findErr(E e);
}
