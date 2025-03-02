package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.entity.User;
import com.example.entity.UserDTO;

import jakarta.validation.Valid;

public interface UserService 
{
	void CreateUser(int id, String firstname, String lastname, String adress, String dob, String email, String password,
			String phoneno);
	
	User findUserById(int id);

	UserDTO getspecificDetail(User user);

	User getUser(@Valid String email,String password);

	void UpdateUser(User user);

	


	
	

	






	

}
