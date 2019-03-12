package com.lanmo.config;

import com.lanmo.bean.Cat;
import com.lanmo.dao.StudentDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * spring 自动注入
 *    DI 注入 IOC容器管理组件之间的依赖关系
 * 1、Autowired
 *    1)、默认优先按照类型去容器中找相应的组件: acp.getBean(StudentService.class);
 *    2)、如果找到类型多个，在将属性的名称作为组件的id去容器中查找
 *           private StudentDao studentDao; acp.getBean("studentDao");
 *    3)、@Qualifier("studentDao") 指定需要装配的组件id,而不是属性名
 *    4)、自动装配默认一定要将属性赋值好，没有会报错
 *        @Autowired(required = false)
 *    5)、@Primary 自动装配首选bean
 *
 * 2、Spring 还支持@Resource(JSR250)和@Inject(JSR330) java
 *      @Resource 默认按照组件名称装配 不支持Spring的@Primary和@Autowired(require=false)功能
 *      @Inject 需要导入javax.inject包 @Autowired(require=false)功能
 *
 * 3、Autowired
 *  ElementType.CONSTRUCTOR, 如果组件只有一个构造器，这个@autowired可以省略
 *  ElementType.METHOD, set get 方法
 *  ElementType.PARAMETER,
 *  ElementType.FIELD,
 *  ElementType.ANNOTATION_TYPE
 *
 * 4、自定义组件想要使用spring容器底层的一些组件(applicationContext,beanFactory,xxx)
 *     只需实现xxxAware (回调模式)
 *
 * @author NJ
 * @date 2019/3/11 17:25
 */
@Configuration
@ComponentScan(value = {"com.lanmo.controller","com.lanmo.dao","com.lanmo.service","com.lanmo.bean"})
public class MainConfigOfAutowired {


    @Primary
    @Bean("studentDao2")
    public StudentDao studentDao(){
        return new StudentDao("2222222222222");
    }

    /**
     * @Bean 标注方法时,方法参数值从容器中获取
     * @return
     */
    @Bean
    public Cat cat(){
        return new Cat();
    }

}
