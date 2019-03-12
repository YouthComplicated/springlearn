package com.lanmo.config;

import com.lanmo.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * bean生命周期
 *     创建--》初始化--》销毁
 *
 * 创建 :
 *      单例 容器创建时候
 *      多例 获取对象时候创建
 *
 * 初始化:对象创建并赋值，调用构造方法
 * 销毁:
 *      单例 容器销毁(close)
 *      多例 容器不会管理bean 需手动调用销毁方法
 *
 *
 * 自定义初始化和销毁方法
 * 1、实现初始化和销毁方法 bean xml 指定(init-method="" destroy-method="")
 *    注解实现  @Bean(initMethod = "init", destroyMethod = "destory") 指定相应的方法
 * 2、实现通过Bean实现相应接口
 *         InitializingBean(初始化)
 *         DisposableBean(销毁)
 * 3、JSR250(java 规范的注解)
 *      @PostConstruct  在bean创建完成并且属性值赋值完成：完成初始化
 *      @PreDestroy   在容器销毁之前通知进行销毁
 * 4、BeanPostProcessor bean后置处理器
 *      bean初始化前后
 *      postProcessBeforeInitialization 在初始化之前
 *      postProcessAfterInitialization  在初始化之后
 *
 *  BeanPostProcessor 原理:
    遍历得到容器所有的BeanPostProcessors
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
    throws BeansException {
    Object result = existingBean;
    for (BeanPostProcessor processor : getBeanPostProcessors()) {
    Object current = processor.postProcessBeforeInitialization(result, beanName);
    if (current == null) {
    return result;
    }
    result = current;
    }
    return result;
    }

    过程：
    populateBean(beanName, mbd, instanceWrapper);
    initializeBean
    {
    applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
    invokeInitMethods(beanName, wrappedBean, mbd);
    applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
    }
 *  spring 底层对BeanPostProcessors

    如何获取IOC容器 实现ApplicationContextAware接口
    public class Customer implements ApplicationContextAware{
    原理：ApplicationContextAwareProcessor
    BeanValidationPostProcessor
    AutowiredAnnotationBeanPostProcessor
    InitDestroyAnnotationBeanPostProcessor 注解如何工作(   @PostConstruct   @PreDestroy)
 * @author NJ
 *
 * @date 2019/3/11 14:32
 */
@ComponentScan("com.lanmo.bean")
@Configuration
public class MainConfigOfLifeCycle {

    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destory")
    public Cat cat(){
        return new Cat();
    }



}
