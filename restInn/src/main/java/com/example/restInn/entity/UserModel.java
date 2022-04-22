package com.example.restInn.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
public class UserModel {
	
	@Id
	private String id;
	
	@NotBlank(message= "First name is mandatory")
	private String firstname;
	
	@NotBlank(message= "Last name is mandatory")
	private String lastname;
	
	@NotBlank(message= "Not a valid email")
	@Email(message= "Not a valid email")
	private String email;
	
	@Min(message= "Password requires length of 6", value=6)
	private String password;
	
	// Constructors
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(String id, String firstname, String lastname, String email, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
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
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
