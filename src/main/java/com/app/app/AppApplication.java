package com.app.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext();
        a.register();
        new AnnotatedBeanDefinitionReader(a).register();
        new AnnotatedBeanDefinitionReader(a).register();
        a.refresh();
    }


}
