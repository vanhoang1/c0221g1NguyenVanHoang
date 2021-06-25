package com.validate_form_reg.model.service;

import com.validate_form_reg.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IUserService {
    Page<User> findAll(Pageable pageable);

    void save(User product);

    Optional<User> findById(long id);

    void remove(long id);
}
