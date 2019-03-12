package com.lanmo.config;

import com.lanmo.bean.Person;
import com.lanmo.bean.aware.Apple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author NJ
 * @date 2019/3/11 16:26
 */
@Configuration
//读取外部数据的配置文件
@PropertySource(value={"classpath:config.properties"})
//@PropertySource(value = "file:${user.dir}/config/customize.properties",
public class MainConfigOfPropertyValue {

    @Bean
    public Person person(){
        return new Person();
    }

    @Bean
    public Apple apple(){
        return new Apple();
    }


}


