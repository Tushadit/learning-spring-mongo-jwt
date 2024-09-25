package com.jwt.example.jwtimpl.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	 @GetMapping("/dashboard")
	 @ResponseBody
	    public String adminDashboard() {
	        return "Admin Dashboard";
	    }

}
