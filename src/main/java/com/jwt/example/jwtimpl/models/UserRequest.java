package com.jwt.example.jwtimpl.models;

import java.util.Set;

public class UserRequest {

	
	private String name;
    private String email;
    private String password;
    private Set<String> roles; // Assuming roles are passed as a set of role names

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Set<String> getRoles() { return roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; }
	@Override
	public String toString() {
		return "UserRequest [name=" + name + ", email=" + email + ", password=" + password + ", roles=" + roles + "]";
	}
    
    
    
}
