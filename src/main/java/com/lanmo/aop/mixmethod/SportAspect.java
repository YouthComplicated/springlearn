package com.lanmo.aop.mixmethod;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareAnnotation;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SportAspect {
    @DeclareParents(value="com.lanmo.aop.mixmethod.Person+", defaultImpl = SportsImpl.class)
    public Sports sports;
}
