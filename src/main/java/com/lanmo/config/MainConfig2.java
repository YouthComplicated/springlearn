package com.lanmo.config;

import com.lanmo.bean.PersonFactoryBean;
import com.lanmo.bean.Student;
import com.lanmo.bean.Teacher;
import com.lanmo.condition.LinuxCondition;
import com.lanmo.condition.MyImportBeanDefinitionRegistrar;
import com.lanmo.condition.MyImportSelector;
import com.lanmo.condition.WindowCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

//@Conditional(LinuxCondition.class)
@Configuration
@Import({Teacher.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//1、导入组件，id默认是组件全类名
//2、ImportSelector
//3、ImportBeanDefinitionRegistrar
public class MainConfig2 {

    /**
     * Scope 作用域
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE  多例
     * ConfigurableBeanFactory#SCOPE_SINGLETON  单例 默认为单例
     * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * 同一次请求创建一个实例
     * org.springframework.web.context.WebApplicationContext#SCOPE_SESSIO
     * 同一个session创建一个实例
     *
     * 单例：IOC容器启动时调用方法创建实例
     *
     * 多例：IOC容器启动不会调用方法创建容器，每次获取时候创建对象
     *
     * 懒加载(只针对单实例bean)
     *      单实例bean
     * @return
     */
//    @Scope(scopeName= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Scope(scopeName= ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    @Bean("student")
    public Student student(){
        System.out.println("容器中添加bean。。。。。");
        return  new Student("lisi", 1111);
    }


    /**
     * @Conditional 按照一定条件进行判断，满足条件加载bean
     * @return
     */
    @Conditional(WindowCondition.class)
    @Bean("window")
    public Student student1(){
        System.out.println("容器中添加bean。。。。。");
        return  new Student("window", 222);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linux")
    public Student student2(){
        System.out.println("容器中添加bean。。。。。");
        return  new Student("linux", 4444);
    }

    /**
     * 给容器中注册组件
     * 1、包扫描+组件注解(@Controller,@Service,@Repository,@Component)
     * 2、@Bean[导入第三包里面的组件]
     * 3、@Import 快速给容器导入一个组件
     *  //1、导入组件，id默认是组件全类名
     *  //2、ImportSelector
     *  //3、ImportBeanDefinitionRegistrar
     * 4、FactoryBean
     *   默认使用getObject()创建对象
     *   获取工厂bean本身,需要在id前面加&
     *
     * 周期
     */

    @Bean
    public PersonFactoryBean personFactoryBean(){
        return new PersonFactoryBean();
    }
}
