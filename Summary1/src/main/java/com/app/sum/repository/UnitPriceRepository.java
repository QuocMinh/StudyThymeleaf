package com.app.sum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.app.sum.model.CustomerType;
import com.app.sum.model.UnitPrice;

public interface UnitPriceRepository extends MongoRepository<UnitPrice, String> {
	
	@Query("{customerTypeId : ?0}")
	UnitPrice findByCustomerTypeId(CustomerType customerType);
	
}
