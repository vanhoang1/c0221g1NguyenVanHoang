package model.service.api;

import model.bean.Customer;

import java.util.List;

public interface Service<E> {
    List<E> findAll();
    boolean save(E e);
    E findById(int id);
    boolean update(int id, E e);
    boolean  remove(int id);
    List<E> findByName(String search);
}
