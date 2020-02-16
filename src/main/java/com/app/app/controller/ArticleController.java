package com.app.app.controller;

import org.springframework.web.bind.annotation.RequestParam;


public class ArticleController {

    public String upload(@RequestParam("title") String title) {
        return "gg";
    }
}
