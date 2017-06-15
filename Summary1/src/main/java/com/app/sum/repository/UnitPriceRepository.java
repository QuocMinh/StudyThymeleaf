package com.app.sum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.sum.dao.UnitPriceRepositoryCustom;
import com.app.sum.model.UnitPrice;

public interface UnitPriceRepository extends MongoRepository<UnitPrice, String>, UnitPriceRepositoryCustom {
	
}
