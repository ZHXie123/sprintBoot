package com.xzh.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class logAdvice {

    @Before("com.xzh.PointCut.PointCut.delete()")
    public void before(JoinPoint joinPoint){
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        String methodname = joinPoint.getSignature().getName();
        System.out.println("simplename="+simpleName);
        System.out.println("---------------------------");
        System.out.println("methodname="+methodname);
    }

    @Before("com.xzh.PointCut.PointCut.getone()")
    public void beforeSe(JoinPoint joinPoint){
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        String methodname = joinPoint.getSignature().getName();
        System.out.println("simplename="+simpleName);
        System.out.println("---------------------------");
        System.out.println("methodname="+methodname);
    }


}
