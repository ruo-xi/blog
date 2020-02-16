package com.app.app.service;

import com.app.app.dao.UserMapper;
import com.app.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Integer addUser(User user) {
        return userMapper.add(user);
    }

    public Collection<User> getUsers() {
        return userMapper.getUsers();
    }

    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public boolean isUserExisted(String name) {
        if (null == userMapper.getUserByName(name)) {
            return false;
        } else {
            return true;
        }
    }

    public Integer getIdByNP(String name, String password) {
        return userMapper.getIdByNP(name, password);
    }

    public Integer updateBasicMsg(String param, String value, Integer id) {
        return userMapper.updateUserMsg(param, value, id);
    }

    public Integer updateUserP(Integer id, String password) {
        return userMapper.updateUserP(id, password);
    }
}
