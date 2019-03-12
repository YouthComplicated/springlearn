package com.lanmo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author NJ
 * @date 2019/3/11 18:28
 */
//默认容器会调用无参构造器m,在进行初始化赋值操作
@Component
public class Bear  {


//    @Autowired
    private Cat cat;

//    @Autowired
    public Bear( @Autowired Cat cat) {
        this.cat = cat;
        System.out.println("===========有参构造器============");
    }

    public Cat getCat() {
        return cat;
    }

    //标注在方法上 spring 容器调用该方法，完成赋值
//    @Autowired
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Bear{" +
                "cat=" + cat +
                '}';
    }
}
