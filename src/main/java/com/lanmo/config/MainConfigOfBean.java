package com.lanmo.config;

import com.lanmo.bean.Student;
import org.springframework.context.annotation.Bean;

/**
 * 默认spring(单例) 会判断bean是否已经存在
 */
public class MainConfigOfBean {

    @Bean
    public Student student(){
        return new Student("张三",11333);
    }

    @Bean
    public Student anOtherstudent(){
        return new Student("张三",11333);
    }
}
