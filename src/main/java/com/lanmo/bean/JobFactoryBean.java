package com.lanmo.bean;

import org.springframework.beans.factory.FactoryBean;

public class JobFactoryBean  implements FactoryBean<Person> {

    public Person getObject() throws Exception {
        return null;
    }

    public Class<?> getObjectType() {
        return null;
    }
}
