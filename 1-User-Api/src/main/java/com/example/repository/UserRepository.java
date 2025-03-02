package com.example.repository;


import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.User;

import jakarta.validation.Valid;

public interface UserRepository extends JpaRepository<User, Integer> 
{

	@Query(value = "SELECT * FROM user WHERE email = :arg1 AND password = :arg2", nativeQuery = true)
    Optional<User> findByEmailAndPassword(@Param("arg1") String email, @Param("arg2") String password);


}