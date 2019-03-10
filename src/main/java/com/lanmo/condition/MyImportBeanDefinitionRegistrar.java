package com.lanmo.condition;

import com.lanmo.bean.Animal;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * @param importingClassMetadata  当前类信息
     * @param registry
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//        boolean definition1 = registry.containsBeanDefinition("person");
        boolean definition1 = registry.containsBeanDefinition("com.lanmo.bean.Teacher");
        boolean definition2 = registry.containsBeanDefinition("com.lanmo.bean.Customer");
        if(definition1 && definition2){
            //beans
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Animal.class);
            registry.registerBeanDefinition("animal", rootBeanDefinition);
        }
    }
}
