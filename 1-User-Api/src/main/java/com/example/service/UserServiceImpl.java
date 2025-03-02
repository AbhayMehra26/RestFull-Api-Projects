package com.example.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public void CreateUser(User user) 
{
	ur.save(user);
	
}

@Override
public User findUserById(int id) 
{
	
	return ur.findById(id).orElse(null);
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
	ur.save(user);
}








/*@Override
public Integer getIdByEmailAndPassword(String email, String password) 
{
    Optional<User> user = ur.findByEmailAndPassword(email, password);
    
    // If the user exists, return their ID; otherwise, return null
    
    return user.map(User::getId).orElse(null);
}
*/


}








