package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.entity.User;
import com.example.entity.UserDTO;
import com.example.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("user-Api")
public class UserController 
{
	@Autowired UserService us;
	
	@PostMapping("user")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user)
	{
		us.CreateUser(user.getId(),user.getFirstname(),user.getLastname(),user.getAdress(),user.getDob(),user.getEmail(),user.getPassword(),user.getPhoneno());
		return ResponseEntity.status(201).body(user);
	}
	
	
	// url----> http://localhost:8080/ user-Api/user/101
	@GetMapping("user/{userid}")
	public ResponseEntity<UserDTO> getUserinfo(@PathVariable("userid")  int id )
	{
		User user=us.findUserById(id);
		if(user==null)			
		return ResponseEntity.status(404).build();
		UserDTO dto=us.getspecificDetail(user);
		return ResponseEntity.status(200).body(dto);
	}
	
    @GetMapping("user/{email}/{password}")
	public ResponseEntity<Integer> Authantication(@Valid @PathVariable String email,@PathVariable String password)
	{
	   User user=us.getUser(email,password);
	   if(user==null)
	  
		return ResponseEntity.status(404).build();
	  
	     int userid= user.getId();
		return ResponseEntity.status(200).body(userid);
	}
	
    @PutMapping("user/{userid}")
	public ResponseEntity<User> UpdateUserinfo(@PathVariable("userid")  int id,@RequestBody User user )
	{
		User olduser=us.findUserById(id);
		if(user==null)			
		return ResponseEntity.status(404).build();
		user.setId(id);
		us.UpdateUser(user);
		return ResponseEntity.status(200).body(user);
	}
}
	

		

