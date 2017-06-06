package com.app.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.app.main.model.Accounts;

public interface AccountRepository extends MongoRepository<Accounts, String> {
	
	// Custom method ...
	
	@Query("{username : ?0}")
	public Accounts findUserByUsername(String username);
	
	// ... Custom method
	
}
