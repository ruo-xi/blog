package com.app.app.controller;

import com.alibaba.fastjson.JSON;
import com.app.app.entity.ResultBean;
import com.app.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping(value = "/401")
    public String test() {

        return "401";
    }
}
