package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.MyService;
@RestController
public class DemoController {
	@Autowired
	private MyService myservice;
	
    @RequestMapping("/")
    public String index() {
    	myservice.method("我是参数");
        return "Hello Spring Boot!";
    }
}
