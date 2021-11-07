package com.paisabook.controllers;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paisabook.entities.Transaction;
import com.paisabook.entities.User;
import com.paisabook.model.Response;
import com.paisabook.model.TransactionOutDto;
import com.paisabook.model.UserDto;
import com.paisabook.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userservice;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addNewUser(UserDto userdto){
		
		User user = UserDto.toEntity(userdto);
		user = userservice.saveUser(user);
		UserDto dto = UserDto.fromEntity(user);
		return Response.success(user);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id")int id){
		User user = userservice.getUserData(id);
		return Response.success(UserDto.fromEntity(user));
	}
	
	@GetMapping("/getAllTransactionByUserId/{id}")
	public ResponseEntity<?> getAllDoctorsBySpId(@PathVariable("id") int id){
		List<Transaction> list = userservice.getAllTransactionsByUserId(id);
		Stream<TransactionOutDto> result = list.stream().map(transaction -> TransactionOutDto.fromEntity(transaction));
		return Response.success(result);
	}
}
