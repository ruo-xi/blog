package com.app.app.controller;

import com.app.app.entity.ResultBean;
import com.app.app.entity.User;
import com.app.app.service.UserService;
import com.app.app.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("name") String name, @RequestParam("password") String pwd) {
        User user = userService.getUserByName(name);

        if (null == user) {
            return ResultBean.error(ResultBean.ERROR, "不存在此用户").toString();
        }

        Integer id = userService.getIdByNP(name, pwd);

        return ResultBean.success(id).toString();

//        if(user.getPassword().equals(pwd)){
//            return ResultBean.success(JWTUtil.sign(name, pwd, id)).toString();
//        }else {
//            return ResultBean.error(ResultBean.ERROR,"密码错误").toString();
//        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(@RequestParam("id") Integer id) {
        //todo
        return "";
    }
}
