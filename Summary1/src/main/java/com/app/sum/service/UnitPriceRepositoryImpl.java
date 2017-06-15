package com.app.sum.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.app.sum.dao.UnitPriceRepositoryCustom;
import com.app.sum.model.UnitPrice;

public class UnitPriceRepositoryImpl implements UnitPriceRepositoryCustom {
	
	@Autowired
	MongoTemplate template;

	@Override
	public UnitPrice findByCustomerType(String customerTypeId) {
		
		Query query = new Query();
		query.addCriteria(
				Criteria
					.where("customerType.$ref")
					.is("customerType")
					.and("customerType.$id")
					.is(new ObjectId(customerTypeId))
				);
		
		UnitPrice unitPrice = template.findOne(query, UnitPrice.class);
		
		return unitPrice;
	}
	

}
