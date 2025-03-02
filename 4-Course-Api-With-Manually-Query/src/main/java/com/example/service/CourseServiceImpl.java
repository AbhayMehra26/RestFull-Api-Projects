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
	public void addCourse(int cid,String cname, String cduration, int cprice) {
		cr.Coursesave(cid,cname, cduration, cprice);
	}
	
	

	@Override
	public List<Course> getAllRecord() 
	{
		
		return cr.findAllCourses();
	}




	@Override
	public Course findByid(int cid) 
	{
		
		return cr.findByUserId(cid);
	}



	@Override
	public void coursedeleteByid(int cid) 
	{
		 cr.deleteUserById(cid);
	}



	@Override
	public void courseUpdateByid(Course course) 
	{
		Integer cid=course.getCid();
		String cname = course.getCname();  
		String cduration=course.getCduration();
		Integer cprice=course.getCprice();
		
		 cr.updateCourseById(cname,cduration,cprice,cid);
	}



	@Override
	public void patchCourseUpdateByid(Course oldcourse, Course newcourse) 
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
