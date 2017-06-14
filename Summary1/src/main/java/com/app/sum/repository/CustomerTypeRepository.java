package com.app.sum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.app.sum.model.CustomerType;

public interface CustomerTypeRepository extends MongoRepository<CustomerType, String> {
	
	@Query("{customerType : ?0}")
	CustomerType findByCustomerType(String customerType);

}
