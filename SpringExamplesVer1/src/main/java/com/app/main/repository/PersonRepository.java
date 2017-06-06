package com.app.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.main.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
	
	

}
