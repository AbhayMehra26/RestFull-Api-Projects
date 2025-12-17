package com.example.studentcourse.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentcourse.entity.Student;
import com.example.studentcourse.repository.StudentRepository;
import com.example.studentcourse.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository sr;

	@Override
	public void createStudent(Student student) 
	{
		sr.save(student);
		
	}

	@Override
	public List<Student> getAllStudent() 
	{
		
		return sr.findAll();
	}
	

}
