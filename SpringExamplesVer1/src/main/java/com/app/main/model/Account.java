package com.app.main.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Account {
	
	@Id
	private String id;
	
	@Indexed(unique=true)
	private String username;
	private String password;
	private String role; // {admin, user}
	
	public Account() {
		super();
	}

	public Account(String id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Account(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	/**
	 * Create User that default role is user.
	 * 
	 * @param username
	 * @param password
	 */
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.role = "user";
	}

	/**
	 * Create user that have passwod is random String
	 * 
	 * @param username
	 */
	public Account(String username) {
		super();
		this.username = username;
		
		System.out.println("Password: " + autoCreatePassword());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String autoCreatePassword() {
		// Random here
		// ...
		String pwd = "1234@4321";
		
		// Set passwod for this User
		this.password = pwd;
		
		return pwd;
	}
	
}
