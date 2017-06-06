package com.app.main.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Person {
	
	@Id
	private String id;
	
	private String firstName;
	private String lastName;
	@DateTimeFormat(iso=ISO.DATE)
	private Date dob;
	private Accounts account;
	
	public Person() {
		super();
	}

	public Person(String id, String firstName, String lastName, Date dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

	public Person(String firstName, String lastName, Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	
	public Person(String firstName, String lastName, String dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.dob = convertStringToDOB(dob);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getDobString() {
		return convertDOBToString(this.dob);
	}
	
	public Accounts getAccount() {
		return account;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}

	public Date convertStringToDOB(String source) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			return formatter.parse(source);
			
		} catch (ParseException e) {
			e.printStackTrace();
			
			return new Date();
		}
	}
	
	public String convertDOBToString(Date dob) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		return formatter.format(dob);
	}
	
}
