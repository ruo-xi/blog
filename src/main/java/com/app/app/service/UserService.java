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

    public int addUser(User user) {
        return userMapper.add(user);
    }

    public Collection<User> getUsers(){
        return userMapper.getUsers();
    }

    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    public User getUserById(int id){
        return userMapper.getUserById(id);
    }

    public boolean isUserExisted(String name) {
        if (null == userMapper.getUserByName(name)) {
            return false;
        } else {
            return true;
        }
    }


    public int updateBasicMsg(String param, String value, int id) {
        return userMapper.updateUserMsg(param, value, id);
    }

    public int updateUserP(int id, String password) {
        return userMapper.updateUserP(id, password);
    }
}
