package com.model.service.impl;

import com.model.bean.User;
import com.model.repository.UserRepository;
import com.model.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class IUserService implements UserService {
    UserRepository userRepository = new UserRepository();
    @Override
    public void insertUser(User user) {
        userRepository.add(user);
    }

    @Override
    public User selectUser(int id) {
        return userRepository.getUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepository.getList();
    }

    @Override
    public boolean deleteUser(int id) {
        return userRepository.delUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userRepository.update(user);
    }

    @Override
    public List<User> findByCountry(String country) {
        return userRepository.findByCountry(country);
    }

    @Override
    public void printSQLException(SQLException ex) {

    }

    @Override
    public List<User> sortByName() {
        return userRepository.sortByName();
    }
}
