package com.lanmo.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {

    /**
     *
     * @param context  上下文
     * @param metadata  注释信息
     * @return
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        ClassLoader classLoader = context.getClassLoader();
        //当前环境信息
        Environment environment = context.getEnvironment();
        //获取bean定义 可以去重添加bean
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");
        if(property.contains("linxu")){
            return true;
        }
        return false;
    }
}
