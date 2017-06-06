package com.app.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.app.main.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	@Query("{firstName : ?0}")
	public Customer findByFirstName(String firstName) throws NullPointerException;
	
	@Query("{lastName : ?0}")
	public Customer findByLastName(String lastName) throws NullPointerException;

}
