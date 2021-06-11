package model.service.api;

import java.util.List;
import java.util.Map;

public interface Service<E> {
    List<E> findAll();
    List<String> save(E e) ;
    E findById(int id);
    List<String> update(int id, E e);
    boolean  remove(int id);
    List<E> findByName(String search);
    List<String> findErr(E e);
}
