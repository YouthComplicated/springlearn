package com.lanmo.bean;

import org.springframework.stereotype.Component;

@Component
public class Cat {

    public Cat() {
        System.out.println("=====construct Cat=====");
    }

    public void init(){
        System.out.println("========init Cat ======");
    }

    public  void destory(){
        System.out.println("========destory Cat =======");
    }

}
