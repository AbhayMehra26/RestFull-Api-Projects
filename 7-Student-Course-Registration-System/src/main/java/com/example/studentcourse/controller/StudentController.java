package com.example.studentcourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentcourse.entity.Student;
import com.example.studentcourse.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentService ss;
	
	@PostMapping("/Add")
	public ResponseEntity<Student>AddStudent(@RequestBody Student student)
	{
		ss.createStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
		
	}
	
	@GetMapping("/All")
	public ResponseEntity<List<Student>>Student()
	{
		List<Student> student=  ss.getAllStudent();
		return ResponseEntity.status(HttpStatus.OK).body(student);
		
	}
	

}
