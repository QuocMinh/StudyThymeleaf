package com.app.sum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.sum.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
}
