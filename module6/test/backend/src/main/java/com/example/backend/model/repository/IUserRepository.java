package com.example.backend.model.repository;

import com.example.backend.model.entity.Question;
import com.example.backend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from  user u where u.user_name = :username and u.password = :password", nativeQuery = true)
    Optional<User> login(String username, String password);
}
