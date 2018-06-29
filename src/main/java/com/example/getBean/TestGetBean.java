package com.example.getBean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.MyService;

public class TestGetBean {
	//用于debug spring 对象注入
	@Test
	public void testUser(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean1.xml");
		MyService service = (MyService) context.getBean("myService");
		System.out.println(service);
		service.method("asdas");
	}
}
