package com.jwt.example.jwtimpl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.example.jwtimpl.models.Post;
import com.jwt.example.jwtimpl.models.User;
import com.jwt.example.jwtimpl.repository.PostRepository;
import com.jwt.example.jwtimpl.repository.UserRepository;

@Service
public class PostService {
	
	 @Autowired
	    private PostRepository postRepository;

	    @Autowired
	    private UserRepository userRepository;

	    public Post createPost(String userId, String title, String content) {
	        // Fetch the user by their userId
	        User user = userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

	        // Create a new post and associate it with the user
	        Post post = new Post(title, content, user);
	        
	        // Save the post to MongoDB
	        return postRepository.save(post);

	    }
	    
	    public List<Post> readAllPost(String userId){
	    	
	    	// Check if the user exists first
	        User user = userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

	        // Return the list of posts for the user
	        return postRepository.findByUserUserId(userId);
	    	
   	
	    }
	    
	    public Post readPostById(String userId, String postId) {
	        User user = userRepository.findById(userId)
	                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
	        
	        return postRepository.findByPostIdAndUserUserId(postId, userId)
	                .orElseThrow(() -> new RuntimeException("Post not found with ID: " + postId + " for user ID: " + userId));
	    }

	    
}
