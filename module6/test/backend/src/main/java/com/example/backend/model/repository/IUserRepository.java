package com.example.backend.model.repository;

import com.example.backend.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Question, Long> {
}
