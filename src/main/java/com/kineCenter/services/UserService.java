package com.kineCenter.services;

import java.util.List;

import com.kineCenter.entities.User;

public interface UserService {
	User saveUser(User u);
	User updateUser(User u);
	void deleteUser(User up);
	 void deleteUserById(Long id);
	 User getUser(Long id);
	List<User> getAllUser();
	User findByUsername(String username);
	List<User> ListUsers2();
	
}
