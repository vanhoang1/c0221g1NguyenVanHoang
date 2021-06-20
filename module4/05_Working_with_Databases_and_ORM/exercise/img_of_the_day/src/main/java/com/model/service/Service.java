package com.model.service;
import java.util.List;

public interface Service<E> {

    List<E> findAll();

    E findOne(Long id);

    List<E> findAllOnCurrentDate();



    E save(E e);

    List<E> save(List<E> e);

    boolean exists(Long id);

    List<E> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(E e);

    void delete(List<E> e);

    void deleteAll();

    E add(E e);

    void like(long id);

}
