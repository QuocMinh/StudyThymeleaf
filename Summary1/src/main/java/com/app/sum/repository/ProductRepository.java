package com.app.sum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.sum.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
