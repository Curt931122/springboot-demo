package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTest {
	@Pointcut("execution(public * com.example.service.*.*(..))")  
    public void webLog(){} 
	
	@Before("webLog()")  
    public void deBefore(JoinPoint joinPoint) throws Throwable {
		System.out.println("开始执行service");
	}
}
