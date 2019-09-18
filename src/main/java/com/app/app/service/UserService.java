package com.app.app.service;

import com.app.app.dao.UserMapper;
import com.app.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int addUser(User user) {
        return userMapper.add(user);
    }

    public User getUser(String name) {
        return userMapper.getUserByName(name);
    }

    public boolean isUserExisted(String name) {
        if (null == userMapper.getUserByName(name)) {
            return false;
        } else {
            return true;
        }
    }

    public int updateBasicMsg(User user) {
        return userMapper.updateBasicMsg(user);
    }

    public int updateUserP(int id, String password) {
        return userMapper.updateUserP(id, password);
    }
}
