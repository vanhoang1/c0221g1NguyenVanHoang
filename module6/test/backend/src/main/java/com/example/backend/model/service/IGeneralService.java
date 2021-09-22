package com.example.backend.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService<T> {
    Page<T> findAllWithKeyWord(Pageable pageable,String keyword);

    Optional <T> findById(Long id);

    Iterable<T> findAllNormal();

    void create(T t);
    void update(T t);

    void remove(Long id);
}

