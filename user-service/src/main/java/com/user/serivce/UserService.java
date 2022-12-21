package com.user.serivce;

import java.util.List;

import com.user.model.User;

public interface UserService {
	public User saveUser(User user);
	
	public List<User> getAllUsers();
	
	public User getByUserId(String userId);
}
