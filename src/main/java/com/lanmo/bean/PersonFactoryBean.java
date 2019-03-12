package com.lanmo.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 工厂类控制bean创建
 */
public class PersonFactoryBean  implements FactoryBean<Person> {

    public Person getObject() throws Exception {
        System.out.println("==工厂类创建benan调用getObject()======");
        return new Person();
    }

    public Class<?> getObjectType() {
        return Person.class;
    }

    //是否单例和多例
    public boolean isSingleton() {
        return true;
    }
}
