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

import com.example.studentcourse.entity.Course;
import com.example.studentcourse.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController 
{
	@Autowired
	private CourseService cs;
	
	@PostMapping("/Add")
	public ResponseEntity<Course>AddCourse(@RequestBody Course course )
	{
		cs.createCourse(course);
		return ResponseEntity.status(HttpStatus.CREATED).body(course);
		
	}
	
	@GetMapping("/All")
	public ResponseEntity<List<Course>>getCourse()
	{
		List<Course> course=  cs.getAllCourse();
		return ResponseEntity.status(HttpStatus.OK).body(course);
		
	}
	

}
