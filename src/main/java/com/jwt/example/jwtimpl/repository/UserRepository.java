package com.jwt.example.jwtimpl.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jwt.example.jwtimpl.models.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	public Optional<User> findByEmail(String email);

}
