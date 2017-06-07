package com.app.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.app.main.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
	
	@Query("{lastName : ?0}")
	public Person findPersonByLastName(String lastName);

}
