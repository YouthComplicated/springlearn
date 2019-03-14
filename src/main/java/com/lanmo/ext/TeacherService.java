package com.lanmo.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NJ
 * @date 2019/3/14 14:33
 */
@Service
public class TeacherService {


    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event){
        System.out.println("UserService...监听到的事件"+event);
    }




    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        String   value = String.format("%.2f", map.get("null"));
        System.out.println();


        List<Integer> list = new ArrayList<>();
        list.add(88);
        list.add(999);
        Integer ii = 00;
        System.out.println(list.contains(ii));
    }
}
