package com.example.mq;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Tut1Sender {
	@Autowired
    private AmqpTemplate template;
	
	@Autowired
    private Queue queue;
	
	@Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello World!" + new Date();
        template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
