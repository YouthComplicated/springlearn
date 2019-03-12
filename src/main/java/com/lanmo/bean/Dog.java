package com.lanmo.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Dog implements InitializingBean, DisposableBean{

    public Dog(){
        System.out.println("====Dog construct==");
    }

    public void destroy() throws Exception {
        System.out.println("====Dog destory==");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("====Dog afterPropertiesSet...");
    }
}
