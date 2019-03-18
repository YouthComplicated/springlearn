package com.lanmo.aop.mixmethod;

import org.springframework.stereotype.Component;

@Component
public class Teacher implements Person {

    public void toShow(){
        System.out.println(" i am teacher!");
    }
}
