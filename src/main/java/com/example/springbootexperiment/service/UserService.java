package com.example.springbootexperiment.service;

import com.example.springbootexperiment.entity.User;

import java.util.List;

public interface UserService {

    boolean saveUser(User user);
    boolean removeUserById(Long id);
    boolean updateUserById(User user);
    User getUserById(Long id);
    List<User> listUsers();
    User getUserAndBooksByUserName(String userName);
}
