package com.borrow_book.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IService <E> {
    Page<E> findAllWithKeyWord(Pageable pageable , String keyword);

    List<E> findAll();

    void save(E e)  throws Exception;

    Optional<E> findById(int id)  throws Exception;

    void remove(int id);
}
