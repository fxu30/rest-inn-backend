package com.example.restInn.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
public class UserModel {
	
	@Id
	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	
	// Constructors
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserModel(String id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstname = firstName;
		this.lastname = lastName;
		this.email = email;
		this.password = password;
	}

	// Getter,Setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastName) {
		this.lastname = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
