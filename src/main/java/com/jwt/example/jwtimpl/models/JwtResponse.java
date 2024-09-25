package com.jwt.example.jwtimpl.models;

public class JwtResponse {
	
	private String jwtToken;
	private String username;

	// All-args constructor
	public JwtResponse(String jwtToken, String username) {
		this.jwtToken = jwtToken;
		this.username = username;
	}

	// No-args constructor
	public JwtResponse() {
	}

	// Getters and Setters
	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// toString method
	@Override
	public String toString() {
		return "JwtResponse{" +
				"jwtToken='" + jwtToken + '\'' +
				", username='" + username + '\'' +
				'}';
	}

	public static JwtResponse create() {
		return new JwtResponse();
	}

	public JwtResponse withJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
		return this;
	}

	public JwtResponse withUsername(String username) {
		this.username = username;
		return this;
	}
}
