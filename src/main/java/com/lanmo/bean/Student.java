package com.lanmo.bean;

/**
 * spring 配置方法
 *
 * 1、xml中进行显式配置
 *
 * 2、java中进行显式配置
 *
 * 3、隐式bean发现机制和自动装配
 *  组件扫描:component scanning  通过应用上下文所创建bean
 *  自动装配:autowiring  自动满足bean之间的依赖关系
 *
 *
 *
 */
public class Student {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student() {
    }
    // bean 必须指定无参的构造函数么???  bean.xml 有报错找不到无参构造器
    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
