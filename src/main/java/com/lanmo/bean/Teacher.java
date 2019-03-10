package com.lanmo.bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Teacher {

    private  Integer age;

    private String name;

    private String prefession;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefession() {
        return prefession;
    }

    public void setPrefession(String prefession) {
        this.prefession = prefession;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", prefession='" + prefession + '\'' +
                '}';
    }

    public Teacher() {
    }

    public Teacher(Integer age, String name, String prefession) {
        this.age = age;
        this.name = name;
        this.prefession = prefession;
    }
}
