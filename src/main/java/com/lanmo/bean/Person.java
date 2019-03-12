package com.lanmo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.List;


public class Person {
     //使用@
    /**
     * 使用@Value 赋值
     * 1、基本数值
     * 2、可以写SpEl #{}
     * 3、${} 取出配置文件中的值(运行环境变量中)
     */
    @Value("李四")
    private String name;

    @Value("#{79-2}")
    private Integer age;

    @Value("#{'${name}'.split(';')}")
    private List<String> numNames;

    @Value("${school}")
    private String school;

    public Person() {
    }


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

    public List<String> getNumNames() {
        return numNames;
    }

    public void setNumNames(List<String> numNames) {
        this.numNames = numNames;
    }

    public Person(List<String> numNames) {
        this.numNames = numNames;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", numNames=" + numNames +
                ", school='" + school + '\'' +
                '}';
    }
}
