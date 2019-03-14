package com.lanmo.ext;

import com.lanmo.bean.Cat;
import com.lanmo.bean.Dog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

/**
 * @author NJ
 * @date 2019/3/14 10:36
 */
@Component
public class MyBeanDifinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor{


    /**
     * registry 包含bean的注册信息
     * @param registry
     * @throws BeansException
     */
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDifinitionRegistryPostProcessor...bean的数量:" + registry.getBeanDefinitionCount());
        RootBeanDefinition beanDefinition = new RootBeanDefinition(Cat.class);
        registry.registerBeanDefinition("tomzhang", beanDefinition);

        AbstractBeanDefinition beanDefinition1 = BeanDefinitionBuilder.rootBeanDefinition(Dog.class).getBeanDefinition();
        registry.registerBeanDefinition("李四好好", beanDefinition1);


    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory...bean的数量:"+ beanFactory.getBeanDefinitionCount());
    }
}
