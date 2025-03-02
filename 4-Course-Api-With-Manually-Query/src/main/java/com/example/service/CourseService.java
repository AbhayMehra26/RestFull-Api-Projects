package com.example.service;

import java.util.List;

import com.example.entity.Course;

public interface CourseService 
{
	void addCourse( int cid, String cname, String cduration, int cprice);

	//void addCourse(Course course);

	List<Course> getAllRecord();

	Course findByid(int cid);

	void coursedeleteByid(int cid);

	void courseUpdateByid(Course course);

	void patchCourseUpdateByid(Course oldcourse, Course newcourse);



}
