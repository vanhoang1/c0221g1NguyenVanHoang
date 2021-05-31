package com.model.service;

import com.model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void  insertUser(User user);
    User selectUser(int id);
    List<User> selectAllUsers();
    boolean deleteUser(int id);
    boolean updateUser(User user);
    List<User> findByCountry(String country);
    void printSQLException(SQLException ex);
}
