package com.app.main.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.main.model.Customer;
import com.app.main.repository.CustomRepository;
import com.app.main.repository.CustomerRepository;

public class CustomerServices implements CustomRepository{
	
	@Autowired
	CustomerRepository repository;

	@Override
	public void findByLastName() {
		for (Customer customer : repository.findAll()) {
			System.out.println(customer.toString());
		}
	}
	
}
