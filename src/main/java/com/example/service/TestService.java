package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.User;

@Component
public class TestService {
	@Autowired
	private UserService userService;
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
    public String test1() {
    	User user = userService.selectByPrimaryKey(3L);
    	user.setName(Long.valueOf(Long.valueOf(user.getName()).longValue() + 1L).toString());
    	Integer i = userService.update(user);
		while(i==0) {
			user = userService.selectByPrimaryKey(3L);
			user.setName(Long.valueOf(Long.valueOf(user.getName()).longValue() + 1L).toString());
			i = userService.update(user);
		}
		return null;
    }
}
