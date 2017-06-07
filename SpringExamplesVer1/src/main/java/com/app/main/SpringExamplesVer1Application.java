package com.app.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.main.repository.CustomerRepository;
import com.app.main.repository.PersonRepository;

@SpringBootApplication
public class SpringExamplesVer1Application implements CommandLineRunner{
	
	@Autowired
	private CustomerRepository customRepository;
	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringExamplesVer1Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
	}
	
}
