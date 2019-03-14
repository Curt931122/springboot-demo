package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.UserMapper;
import com.example.model.User;

@Component
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private TestService testService;
	
	public User selectByPrimaryKey(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public Integer insert(User user) {
		return userMapper.insert(user);
	}
	
	public Integer update(User user) {
		return userMapper.update(user);
	}
	
	@Transactional
    public String test() {
    	return testService.test1();
    }

}
