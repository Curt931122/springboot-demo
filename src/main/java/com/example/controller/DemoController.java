package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.MyService;
import com.example.service.UserService;
@RestController
public class DemoController {
	@Autowired
	private MyService myservice;
	
	@Autowired
	private UserService userService;
	
    @RequestMapping("/")
    public String index() {
    	myservice.method("我是参数");
        return "Hello Spring Boot!";
    }
    
    @RequestMapping("/test1")
    public String user() {
        return "Hello Spring Boot!" + userService.test();
    }
    
}
