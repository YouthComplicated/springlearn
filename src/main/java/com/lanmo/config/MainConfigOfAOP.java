package com.lanmo.config;

import com.lanmo.aop.Calc;
import com.lanmo.aop.LogAspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * AOP 基于动态代理
 *
 *
 * 1、 定义日志切面类
 *
 * 2、 通知方法：[切入点表达式]
 *      前置(@Before)   logStart()
 *      后置(@After)   logEnd()  无论正确还是错误
 *      返回(@AfterReturning)   logReturn()  运行正常的返回
 *      异常(@AfterThrowing)   logException()
 *      环绕(@Around)   动态代理，手动推进目标运行(joinPoint.proced())
 *
 *  3、切面类和逻辑组件加入到容器中 (切面类加入注解aspect)
 *
 *  4、启用aspect代理  @EnableAspectJAutoProxy
 *      Spring 中 Enablexxx
 *
 *
 *
 * @author NJ
 * @date 2019/3/12 17:55
 */

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    @Bean
    public Calc calc(){
        return new Calc();
    }

    @Bean
    public LogAspects logApects(){
        return new LogAspects();
    }

}
