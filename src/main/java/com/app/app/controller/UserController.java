package com.app.app.controller;


import com.alibaba.fastjson.JSON;
import com.app.app.entity.ResultBean;
import com.app.app.entity.User;
import com.app.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping()
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String getUser() {
        return "lalala";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String regist(@RequestParam("name") String name, @RequestParam("password") String password) {
        if (userService.isUserExisted(name)) {
            return JSON.toJSONString(ResultBean.error(0, "用户已存在"));
        } else {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            if (userService.addUser(user) > 0) {
                return ResultBean.success().toJsonString();
            } else {
                return ResultBean.error(0, "未知错误").toJsonString();
            }
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(){
        return ResultBean.success(userService.getUsers()).toJsonString();
    }

    @RequestMapping(value = "/users/name", method = RequestMethod.GET)
    public String getUser(@RequestParam("name") String name) {
        if (null == userService.getUserByName(name)) {
            return ResultBean.error(1, "用户不存在").toJsonString();
        } else {
            return ResultBean.success(userService.getUserByName(name)).toJsonString();
        }
    }

    @RequestMapping(value = "/users/{id}")
    public String getUser(@PathVariable("id") int id){
           return ResultBean.success(userService.getUserById(id)).toString();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public String updateUserBasicMsg(@PathVariable("id") int id, @RequestParam("param") String param, @RequestParam("value") String value) {
        if (userService.updateBasicMsg(param, value, id) > 0) {
            return ResultBean.success().toJsonString();
        } else {
            return ResultBean.error(0, "未知错误").toJsonString();
        }
    }

    @RequestMapping(value = "/users/{id}/password", method = RequestMethod.PUT)
    public String updateUserP(@PathVariable("id") int id, @RequestParam("password") String password) {
        userService.updateUserP(id,password);
        return ResultBean.success().toString();
    }


}
