package com.lanmo.aop.mixmethod;

import org.springframework.stereotype.Component;

@Component
public class Student implements Person{
    public void showIdentity(){
        System.out.println("i am student!");
    }
}
