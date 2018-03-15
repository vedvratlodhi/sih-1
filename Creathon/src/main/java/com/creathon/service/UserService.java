package com.creathon.service;

import com.creathon.bean.User;

public interface UserService {

	public User validateUser(User user);
	public User findById(Integer id);
	public User findByEmail(String email);

	
}
