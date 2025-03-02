package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Course;
import com.example.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService
{
	@Autowired private CourseRepository cr;

	
	
	@Override
	public List<Course> getAllRecord() 
	{
		
		return cr.findAll();
	}



	@Override
	public void addCourse(Course course) 
	{
		cr.save(course);
	}



	@Override
	public Course findByid(int cid) 
	{
		
		return cr.findById(cid).orElse(null);
	}



	@Override
	public void coursedeleteByid(int cid) 
	{
		 cr.deleteById(cid);
	}



	@Override
	public void courseUpdateByid(Course course) 
	{
		 cr.save(course);
	}



	@Override
	public void PatchcourseUpdateByid(Course oldcourse, Course newcourse) 
	{
		String cname=newcourse.getCname();
		String cduration=newcourse.getCduration();
	    Integer cprice=newcourse.getCprice();
		if(cname!=null)
			oldcourse.setCname(cname);
		if(cduration!=null)
			oldcourse.setCduration(cduration);
		if(cprice!=null)
			oldcourse.setCprice(cprice);
		cr.save(oldcourse);
	}
}
