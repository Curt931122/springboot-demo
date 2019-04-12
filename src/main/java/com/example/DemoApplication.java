package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication  // Spring Boot 项目的核心注解，主要目的是开启自动配置
@ComponentScan("com.example")
@MapperScan({"com.example.mapper"})
@EnableScheduling
public class DemoApplication {
    public static void main(String[] args) {
    	
        SpringApplication.run(DemoApplication.class, args);
    }
}
