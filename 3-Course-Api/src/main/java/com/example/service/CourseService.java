package com.example.service;

import java.util.List;

import com.example.entity.Course;

public interface CourseService 
{

	List<Course> getAllRecord();

	void addCourse(Course course);

	Course findByid(int cid);

	void coursedeleteByid(int cid);

	void courseUpdateByid(Course course);

	void PatchcourseUpdateByid(Course oldcourse, Course newcourse);

}
