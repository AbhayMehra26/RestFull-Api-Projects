package com.example.studentcourse.service;

import java.util.List;

import com.example.studentcourse.entity.Course;

public interface CourseService 
{

	void createCourse(Course course);

	List<Course> getAllCourse();

}
