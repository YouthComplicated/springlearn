package com.lanmo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author NJ
 * @date 2019/3/12 18:17
 */
@Aspect
public class LogAspects {

    //抽取公共的表达式
    //1、本类引用
    //2、其它类引用 方法的全名  官方文档
    @Pointcut("execution( public int com.lanmo.aop.Calc.*(..))")
    public  void pointCut(){
    }

//    @Before("public int com.lanmo.aop.Calc.div(int,int)")
//    @Before("public int com.lanmo.aop.Calc.*(..)")
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        System.out.println("除法运行======参数："+joinPoint.getSignature().getName()+"方法列表"+ Arrays.toString(joinPoint.getArgs()));
    }

    @After("pointCut()")
    public void logEnd(){
        System.out.println("除法结束======");
    }

    //joinPoint 必须出现的参数的第一位
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result){
        System.out.println("除法返回======运行结果：{}" +result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "execption")
    public void logException(Exception execption){
        System.out.println("除法异常=====异常信息：{}"+execption);
    }
}
