package com.jwt.example.jwtimpl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.jwtimpl.models.Post;
import com.jwt.example.jwtimpl.services.PostService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private PostService postService;
	
	 @GetMapping("/profile")
	 @ResponseBody
	    public String userProfile() {
	        return "User Profile";
	    }
	 
	 // Post creation endpoint
	    @PostMapping("/create-post")
	    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest) {
	        try {
	            Post newPost = postService.createPost(postRequest.getUserId(), postRequest.getTitle(), postRequest.getContent());
	            return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	        }
	    }
	    
	    @GetMapping("/{userId}/posts")
	    public ResponseEntity<List<Post>> readAllPost(@PathVariable  String userId){  
	        try {
	            List<Post> userPosts = postService.readAllPost(userId);
	            return ResponseEntity.ok(userPosts);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	        }
	    }
	    
	    @GetMapping("/{userId}/posts/{postId}")
	    public ResponseEntity<?> readPost(@PathVariable  String userId, @PathVariable String postId){  
	    	try {
	            Post post = postService.readPostById(userId, postId);
	            return ResponseEntity.ok(post);
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	    }

	    // Define the PostRequest class here for handling post creation requests
	    public static class PostRequest {
	        private String userId;
	        private String title;
	        private String content;

	        // Getters and Setters
	        public String getUserId(){
	            return userId;
	        }

	        public void setUserId(String userId) {
	            this.userId = userId;
	        }

	        public String getTitle() {
	            return title;
	        }

	        public void setTitle(String title) {
	            this.title = title;
	        }

	        public String getContent() {
	            return content;
	        }

	        public void setContent(String content) {
	            this.content = content;
	        }
	    }
}
