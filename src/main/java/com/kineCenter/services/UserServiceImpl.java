package com.kineCenter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kineCenter.entities.User;

import com.kineCenter.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public User updateUser(User u) {
		
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(User u) {
		userRepository.delete(u);
		
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);

		
	}

	@Override
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> ListUsers2() {
		return userRepository.ListeUsers2();
	}

	

}
