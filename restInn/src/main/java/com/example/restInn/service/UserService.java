package com.example.restInn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.restInn.entity.UserModel;
import com.example.restInn.repository.UserDao;


@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	// Get a user by id
	public UserModel getUser(String userId) {
		Optional<UserModel> user =userDao.findById(userId);
		if(user.isPresent())
		{
			return user.get();
		}
		else
		{
			return new UserModel();
		}
		
	}
	
	// Add a new user
	public UserModel addUser(UserModel user) {
		String pw_hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(pw_hash);
		return userDao.save(user);
		
	}
}
