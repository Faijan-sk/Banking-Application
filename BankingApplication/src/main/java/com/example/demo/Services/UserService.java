package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entities.User;



public interface UserService {
	
	public User createUser(User user);
	
	public List<User> getAllUsers();

	User getUserById(Long id);
	
	User updateUser(Long id, User user);
	
	 void deleteUser(Long id);
}
