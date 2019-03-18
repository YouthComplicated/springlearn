package com.lanmo.aop.mixmethod;

import org.springframework.stereotype.Component;

@Component
public class SportsImpl implements  Sports {
    @Override
    public void doSomething() {
        System.out.println("新增方法...");
    }
}
