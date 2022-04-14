package com.example.restInn.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restInn.entity.UserModel;
import com.example.restInn.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/Users/{userId}")
	public ResponseEntity<UserModel> getUser(@PathVariable String userId) {
		UserModel um = userService.getUser(userId);
		if (um != null) {
			return new ResponseEntity<UserModel>(um,HttpStatus.OK);
		} else {
			return new ResponseEntity<UserModel>(new UserModel(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/Users")
	public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) {
		
		UserModel um =  userService.addUser(user);
		return new ResponseEntity<UserModel>(um, HttpStatus.CREATED);
		
	}
	

}
