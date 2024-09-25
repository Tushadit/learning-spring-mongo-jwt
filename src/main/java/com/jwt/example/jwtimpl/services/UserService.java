package com.jwt.example.jwtimpl.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jwt.example.jwtimpl.models.Role;
import com.jwt.example.jwtimpl.models.User;
import com.jwt.example.jwtimpl.models.UserRequest;
import com.jwt.example.jwtimpl.repository.RoleRepository;
import com.jwt.example.jwtimpl.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
//	public User createUser(User user)
//	{
//		
//		return userRepository.save(user);
//	}
	
	public User createUser(@RequestBody UserRequest userRequest) {
	    if (userRequest == null || userRequest.getRoles() == null || userRequest.getRoles().isEmpty()) {
	        throw new IllegalArgumentException("UserRequest and roles cannot be null or empty");
	    }

	    if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
	        throw new RuntimeException("Email already in use: " + userRequest.getEmail());
	    }

	    User user = new User();
	    user.setName(userRequest.getName());
	    user.setEmail(userRequest.getEmail());
	    user.setPassword(passwordEncoder.encode(userRequest.getPassword())); 

	    Set<Role> roles = new HashSet<>();
	    for (String roleName : userRequest.getRoles()) {
	        Role role = roleRepository.findByName(roleName)
	            .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
	        System.out.println(role);
	        roles.add(role);
	    }

	    user.setRoles(roles);
	    System.out.println(roles.toString());
	    return userRepository.save(user);	    
	}
	
	
}
