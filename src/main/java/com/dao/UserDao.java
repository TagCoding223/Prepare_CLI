package com.dao;

import com.entities.User;

import java.util.List;

public interface UserDao {
    User createUser(User user);
    User findUserById(int id);
    User findUserByEmailAndPassword(String email, String password);
    User updateUser(int id,User user);
    String deleteUser(int id);
    List<User> getAllUser();
    User findByEmail(String email);
}
