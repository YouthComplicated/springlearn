package com.lanmo.ext;

import com.sun.media.sound.SoftTuning;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author NJ
 * @date 2019/3/13 17:51
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor....");
        String[] definitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("已经定义的names:"+ Arrays.asList(definitionNames));
    }
}
