package com.lanmo.ext;

import com.lanmo.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 拓展原理
 *
 *  BeanPostProcessor, bean的后置管理器 bean创建对象初始化前后进行拦截工作
 *
 *  BeanFactoryPostProcessor, 在BeanFactory标准初始化之后调用,所有的bean定义已经保存到
 *  beanFactory,但是bean还没有创建
 *       All bean definitions will have been loaded, but no beans
 *      will have been instantiated yet.
 *  1、IOC容器创建对象
 *  2、	invokeBeanFactoryPostProcessors(beanFactory); 执行BeanFactoryPostProcessors
 *      找到所有的BeanFactoryPostProcessor并执行方法(注意在创建组件之前执行)
 *
 *  BeanDefinitionRegistryPostProcessor 先于BeanFactoryPostProcessor(beanFactory)执行
 *  利用BeanDefinitionRegistryPostProcessor给容器中在额外增加组件
 *
 *
 *  原理：
 *      1)、IOCC创建对象
 *      2)、refresh->>invokeBeanFactoryPostProcessors(beanFactory);
 *      3)、从容器中获取所有BeanDefinitionRegistryPostProcessor
 *          1、依次执行postProcessBeanDefinitionRegistry()
 *          2、然后在执行postProcessBeanFactory()方法 BeanFactoryPostProcessor
 *      4)、在来从容器中找到容器中BeanFactoryPostProcessor组件，然后依次触发postProcessBeanFactory()方法
 *
 *  ApplicationListener 监听容器中发布的事件，事件驱动模块开发
 *      public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
 *      监听ApplicationEvent以及下面的事件
 *
 *  自定义步骤
 *      1)、写一个监听器监听某个事件(applicationEvent及其子类)
 *          或者使用@EventListener;
 *      2)、只要容器中有相关事件发布，就能监听事件
 *          ContextRefreshedEvent: 容器刷新完成(完成所有bean创建)会发布这个事件
 *          ContextClosedEvent:容器关闭会发布事件
 *      3)、如何发布事件
 *        acp.publishEvent()
 *   原理:
 *    1)、ContextRefreshedEvent
 *   容器创建对象:refresh(); -->> finishRefresh(); 容器刷新完成会发布ContextRefreshedEvent事件
 *	    publishEvent(new ContextRefreshedEvent(this));
 *   2)、自己发布的事件
 *   3)、容器关闭发布事件ContextClosedEvent
 *
 *	    事件发布流程：
 *	    1)、获取事件的派发器，getApplicationEventMulticaster()
 *	    2)、getApplicationEventMulticaster().multicastEvent(applicationEvent, eventType);
 *	    3)、获取到所有的ApplicationListener,循环派发(如果有Executor可以异步派发 invokeListener()
 *	    拿到listener回调onApplicationEvent方法
 *
 *  【事件多播器】
 *      1)、IOC Refresh()-->>initApplicationEventMulticaster(); // Initialize event multicaster for this context.
 *      2)、先找id=applicationEventMulticaster组件
 *          如果没有this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory); 加入到容器中
 *
 *
 *  SmartInitializingSingleton
 *       1)、IOC容器创建对象并refresh()
 *       2)、finishBeanFactoryInitialization(beanFactory);初始化剩下的单实例bean
 *          获取所有创建好的单实例bean,判断是否是SmartInitializingSingleton类型的
 *          如果是就调用afterSingletonsInstantiated()方法
 *
 *
 * @author NJ
 *   @date 2019/3/13 17:38
 */
@ComponentScan({"com.lanmo.ext"})
@Configuration
public class ExtConfig {

//    @Bean
    public Cat cat(){
        return new Cat();
    }
}
