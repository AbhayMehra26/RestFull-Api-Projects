package com.example.repository;


import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.User;

import jakarta.validation.Valid;

public interface UserRepository extends JpaRepository<User, Integer> 
{
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO User(id,firstname,lastname,adress,dob,email,password,phoneno)VALUES(:id,:firstname,:lastname,:adress,:dob,:e,:password,:phoneno)",nativeQuery = true)
	void saveUser(@Valid @Param("id") int id, 
			      @Param("firstname")  String firstname,
			      @Param("lastname")   String lastname, 
			      @Param("adress")     String adress,
			      @Param("dob")	       String dob,
			      @Param("e")	       String email,
			      @Param("password")   String password,
			      @Param("phoneno")    String phoneno);


	@Query(value = "Select * From User Where id=:id",nativeQuery = true)
	User findUserById( @Param("id")int id);

	@Query(value = "SELECT * FROM user WHERE email = :arg1 AND password = :arg2", nativeQuery = true)
    Optional<User> findByEmailAndPassword(@Param("arg1") String email, @Param("arg2") String password);


	@Modifying
	@Transactional
	@Query(value = "update user set firstname=:firstname,lastname=:lastname,adress=:adress,dob=:dob,email=:email,password=:password,phoneno=:phoneno",nativeQuery = true)			
	void UpdateUser(@Param("firstname") String firstname, 
			@Param("lastname")String lastname, 
			@Param("adress")       String adress,
			@Param("dob")	        String dob,
			@Param("email")	           String email,
			@Param("password")       String password,
			@Param("phoneno")       String phoneno);

	


}