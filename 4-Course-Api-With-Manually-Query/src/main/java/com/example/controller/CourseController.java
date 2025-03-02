package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Course;
import com.example.service.CourseService;

@RestController
@RequestMapping("course-App")
public class CourseController
{
	@Autowired private CourseService cs;
	
	@PostMapping("courses")
	public ResponseEntity<Course>AddCourse(@RequestBody Course course)
	{
		cs.addCourse(course.getCid(),course.getCname(),course.getCduration(),course.getCprice());
		//cs.addCourse(course);
		return ResponseEntity.status(HttpStatus.CREATED).body(course);
	
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>>getAllCourse()
	{
		List<Course> courselist=cs.getAllRecord();
		return ResponseEntity.status(HttpStatus.OK).body(courselist);
	}
	
	@GetMapping("/courses/{courseId}")
	public ResponseEntity<Course>getByIdCourse(@PathVariable ("courseId") int cid)
	{
		Course course=  cs.findByid(cid);
		 if(course!=null) 
		  return ResponseEntity.status(HttpStatus.OK).body(course);
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<Course>DeleteById(@PathVariable ("courseId") int cid)
	{
		Course course=  cs.findByid(cid);
		 if(course==null) 
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  		  cs.coursedeleteByid(cid);		 
		  return ResponseEntity.status(HttpStatus.OK).body(course);
	}
	
	@PutMapping("/courses/{courseId}")
	public ResponseEntity<Course>updateById(@PathVariable ("courseId") int cid ,@RequestBody Course course)
	{
		Course oldcourse= cs.findByid(cid);
		 if(oldcourse==null) 
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  		 course.setCid(cid);
		 cs.courseUpdateByid(course);		 
		  return ResponseEntity.status(HttpStatus.OK).body(course);		  
	}
	
	@PatchMapping("/courses/{courseId}")
	public ResponseEntity<Course>PatchupdateById(@PathVariable ("courseId") int cid ,@RequestBody Course newcourse)
	{
		Course oldcourse= cs.findByid(cid);
		 if(oldcourse==null) 
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  		 
		 cs.patchCourseUpdateByid(oldcourse,newcourse);		 
		  return ResponseEntity.status(HttpStatus.OK).body(oldcourse);		  
	}
	
	
	
	

}
