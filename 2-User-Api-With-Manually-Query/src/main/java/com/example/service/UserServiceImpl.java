package com.example.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.entity.UserDTO;
import com.example.repository.UserRepository;

import jakarta.validation.Valid;

@Service 
public class UserServiceImpl implements UserService
{
 @Autowired private UserRepository ur;
 @Autowired private  ModelMapper modelMapper;

@Override
public void CreateUser(int id, String firstname, String lastname, String adress, String dob, String email, String password,
		String phoneno) 
{
	ur.saveUser(id, firstname,  lastname,  adress,  dob, email,  password,
			 phoneno) ;
	
	
}

@Override
public User findUserById(int id) 
{
	
	return ur.findUserById(id);
}

//without modelmapper 
/*@Override
public UserDTO getspecificDetail(User user) 
{
	UserDTO dto= new UserDTO();
	dto.setId(user.getId());
	dto.setFirstname(user.getFirstname());
	dto.setLastname(user.getLastname());
	dto.setAdress(user.getAdress());
	dto.setPhoneno(user.getPhoneno());
	dto.setDob(user.getDob());
	return dto;
}
*/

@Override
public UserDTO getspecificDetail(User user) 
{
	UserDTO dto=modelMapper.map(user,UserDTO.class);
	return dto;
}

@Override
public User getUser(@Valid String email ,String password) 
{
	return ur.findByEmailAndPassword(email, password).orElse(null);
   
  
}

@Override
public void UpdateUser(User user) 
{
	String firstname=user.getFirstname();
	String lastname=user.getLastname();
	String adress=user.getAdress();
	String dob=user.getDob();
	String phoneno=user.getPhoneno();
	String email=user.getEmail();
	String password=user.getPassword();

	ur.UpdateUser(firstname,lastname,dob,adress,email,password,phoneno);
}



}








