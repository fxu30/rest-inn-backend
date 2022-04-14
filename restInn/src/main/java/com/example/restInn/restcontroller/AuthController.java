package com.example.restInn.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restInn.entity.UserModel;

@RestController
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/Auth")
	public ResponseEntity<String> login(@RequestBody UserModel user) {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
			return new ResponseEntity<String>("You login sucessfully", HttpStatus.OK);
		
		} catch(UsernameNotFoundException ue) {
			return new ResponseEntity<String>("Your email and/or password were entered incorrectly", HttpStatus.NOT_FOUND);
		} catch(BadCredentialsException be) {
			return new ResponseEntity<String>("Your email and/or password were entered incorrectly", HttpStatus.NOT_FOUND);
		}
			
	}

}
