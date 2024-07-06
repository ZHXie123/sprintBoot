package com.xzh.PointCut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PointCut {

    @Pointcut("execution(* com.xzh.controller.ShowEmployee.deleteOne(..))")
    public void delete(){};

    @Pointcut("execution(* com.xzh.controller.ShowEmployee.showEmployee(..))")
    public void getone(){};
}
