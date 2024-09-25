package com.jwt.example.jwtimpl.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Post {
	
	
	 @Id
	    private String postId;
	    private String title;
	    private String content;

	    // User reference
	    @DBRef
	    private User user; // This is a reference to the User who created the post

	    // Constructors, getters, and setters
	    public Post() {}

	    public Post(String title, String content, User user) {
	        this.title = title;
	        this.content = content;
	        this.user = user;
	    }

	    public String getPostId() {
	        return postId;
	    }

	    public void setPostId(String postId) {
	        this.postId = postId;
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

	    public User getUser() {
	        return user;
	    }

	    public void setUser(User user) {
	        this.user = user;
	    }

}
