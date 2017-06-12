package com.app.sum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.app.sum.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	
	@Query("{roleName : ?0}")
	public Role findByRoleName(String roleName);

}
