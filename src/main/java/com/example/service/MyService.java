package com.example.service;

import org.springframework.stereotype.Component;

import com.example.annotation.MyLogAnnotation;

@Component
public class MyService {
	@MyLogAnnotation("记录执行日志")
	public void method(String param) {
		System.out.println("执行service");
	}
}
