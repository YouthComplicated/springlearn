package com.lanmo.bean;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Customer implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Customer() {
        System.out.println("=====Customer construct =====");
    }

    @PostConstruct
    public void init(){
        System.out.println("========Customer init PostConstruct  ======");
    }

    @PreDestroy
    public  void destory(){
        System.out.println("========Customer destory  PreDestroy =======");
    }
}
