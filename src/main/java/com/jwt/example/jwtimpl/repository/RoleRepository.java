package com.jwt.example.jwtimpl.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jwt.example.jwtimpl.models.Role;


public interface RoleRepository extends MongoRepository <Role, String>{
	
	public Optional<Role> findByName(String role);
	

}
