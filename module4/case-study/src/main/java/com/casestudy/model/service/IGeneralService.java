package com.casestudy.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService<T> {
    Page<T> findAll(Pageable pageable,String keyword);

    Optional <T> findById(Long id);

    Iterable<T> findAllNormal();

    void save(T t);

    void remove(Long id);
}

