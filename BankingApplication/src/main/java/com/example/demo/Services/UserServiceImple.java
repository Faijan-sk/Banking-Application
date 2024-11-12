package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.User;
import com.example.demo.Repositories.UserRepository;

@Service
public class UserServiceImple implements UserService {
	
	@Autowired
	UserRepository userRepository;

	public User createUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		
		return userRepository.findById(id).orElse(null);
	}


	  @Override
	    public User updateUser(Long id, User user) {
	        if (!userRepository.existsById(id)) {
	            return null; 
	        }
	        user.setId(id);  
	        return userRepository.save(user); 
	    }

	  
	  @Override
	    public void deleteUser(Long id) {
	        if (userRepository.existsById(id)) {
	            userRepository.deleteById(id);
	        } else {
	            throw new RuntimeException("User not found with ID: " + id);
	        }
	    }
}
