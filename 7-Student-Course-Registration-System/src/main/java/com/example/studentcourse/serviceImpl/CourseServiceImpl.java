package com.example.studentcourse.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentcourse.entity.Course;
import com.example.studentcourse.repository.CourseRepository;
import com.example.studentcourse.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService
{
	@Autowired
	private CourseRepository cr;

	@Override
	public void createCourse(Course course) 
	{
		cr.save(course);
	}

	@Override
	public List<Course> getAllCourse() 
	{
		return cr.findAll();
	}


}
