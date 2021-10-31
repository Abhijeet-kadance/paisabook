package com.paisabook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paisabook.entities.User;
import com.paisabook.model.Response;
import com.paisabook.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userservice;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addNewUser(){
		User user = new User();
		user = userservice.saveUser(user);
		return Response.success(user);
	}
}
