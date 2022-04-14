package com.example.restInn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.restInn.entity.UserModel;
import com.example.restInn.repository.UserDao;


@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	// Get all users
	public List<UserModel> getAllUsers() {
		return userDao.findAll();
	}
	
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
		String encodedPassword = bcryptPasswordEncoder.encode(user.getPassword());
		//String pw_hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(encodedPassword);
		return userDao.save(user);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel foundUser = userDao.findOneByEmail(username);
		String email = foundUser.getEmail();
		String password = foundUser.getPassword();
		
		return new User(email, password, new ArrayList<>());
	}

	public UserModel getUserByEmail(String email) {
		return userDao.findOneByEmail(email);
	}

}
