package com.example.restInn.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.restInn.entity.UserModel;
import com.example.restInn.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/Users")
	public ResponseEntity<UserModel> getAllUsers() {

		List<UserModel> user = userService.getAllUsers();

		if (user != null) {
			return new ResponseEntity(user, HttpStatus.OK);
		} else {
			return new ResponseEntity(user, HttpStatus.NOT_FOUND);
		}

	}
	
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
	public ResponseEntity<UserModel> createUser(@Valid @RequestBody UserModel user) {
		
		UserModel existedUser = userService.getUserByEmail(user.getEmail());
		if (existedUser == null) {
			UserModel um =  userService.addUser(user);
			return new ResponseEntity<UserModel>(um, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<UserModel>(new UserModel(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	// Validation handler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	

}
