package com.app.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.app.main.model.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
	
	// Custom method ...
	
	@Query("{username : ?0}")
	public Account findAccountByUsername(String username);
	
	// ... Custom method
	
}
