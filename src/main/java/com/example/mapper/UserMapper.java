package com.example.mapper;

import com.example.model.User;

public interface UserMapper {
	public User selectByPrimaryKey(Long id);
	
	public Integer insert(User user);
	
	public Integer update(User user);
}
