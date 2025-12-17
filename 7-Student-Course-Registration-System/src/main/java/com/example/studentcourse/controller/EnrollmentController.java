package com.example.studentcourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentcourse.entity.Course;
import com.example.studentcourse.entity.Enrollment;
import com.example.studentcourse.service.CourseService;
import com.example.studentcourse.service.EnrollmentService;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController 
{
	@Autowired
	private EnrollmentService es;
	
	//  http://localhost:8080/enrollment/Add?course_Id=103&student_Id=8
	@PostMapping("/Add")
	public ResponseEntity<Enrollment>AddEnrollment(@RequestParam long student_Id,@RequestParam long course_Id)
	{
	Enrollment enrollment=es.createEnrollment(course_Id,student_Id);
		return ResponseEntity.status(HttpStatus.CREATED).body(enrollment);
		
	}
	
	//  http://localhost:8080/enrollment/All
	@GetMapping("/All")
	public ResponseEntity<List<Enrollment>>getEnrollment()
	{
		List<Enrollment> enrollment =  es.getAllEnrollment();
		return ResponseEntity.status(HttpStatus.OK).body(enrollment);
		
	}
	

}
