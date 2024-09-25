package com.jwt.example.jwtimpl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jwt.example.jwtimpl.models.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByUserUserId(String userId); 
	
	
	Optional<Post> findByPostIdAndUserUserId(String postId, String userId);

}
