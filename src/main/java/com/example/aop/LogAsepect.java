package com.example.aop;


import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.example.annotation.MyLogAnnotation;

@Aspect
@Component
public class LogAsepect {
	@Pointcut("@annotation(com.example.annotation.MyLogAnnotation)")
    public  void annotationPointCut() {
		
    }
    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){
       MethodSignature sign =  (MethodSignature)joinPoint.getSignature();
       Method method = sign.getMethod();
       MyLogAnnotation annotation = method.getAnnotation(MyLogAnnotation.class);
       System.out.println("打印：-----------" + Arrays.toString(joinPoint.getArgs()));
       System.out.println("打印：-----------" + annotation.value());
    }
}
