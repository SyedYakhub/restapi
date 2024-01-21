package com.twg.springboot.webapprestapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twg.springboot.webapprestapi.entities.User;
import com.twg.springboot.webapprestapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService 
{
    
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(long id) {

		userRepository.deleteById(id);
	}

	@Override
	public User findById(long id) {
		
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public User findByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

}
