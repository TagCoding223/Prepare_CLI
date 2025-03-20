package com.services.servicesImpl;

import com.dao.UserDao;
import com.dao.daoImpl.UserDaoImpl;
import com.entities.User;
import com.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao;

    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    @Override
    public User createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return userDao.findUserByEmailAndPassword(email,password);
    }

    @Override
    public User updateUser(int id, User user) {
        return userDao.updateUser(id,user);
    }

    @Override
    public String deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
