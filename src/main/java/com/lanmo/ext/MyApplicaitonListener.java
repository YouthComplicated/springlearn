package com.lanmo.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author NJ
 * @date 2019/3/14 11:51
 */
@Component
public class MyApplicaitonListener implements ApplicationListener<ApplicationEvent> {

    //当容器中发布事件以后，方法触发
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到事件"+event);
    }
}
