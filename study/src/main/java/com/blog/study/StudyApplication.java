package com.blog.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyApplication {
    public static String gg(){
        try {
            return "try";
        } finally {
            return "finally";
        }
    }

    public static void main(String[] args) {
        System.out.println(gg());
//        SpringApplication.run(StudyApplication.class, args);
    }

}
