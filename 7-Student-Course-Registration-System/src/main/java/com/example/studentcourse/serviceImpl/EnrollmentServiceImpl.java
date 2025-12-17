package com.example.studentcourse.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentcourse.entity.Course;
import com.example.studentcourse.entity.Enrollment;
import com.example.studentcourse.entity.Student;
import com.example.studentcourse.repository.CourseRepository;
import com.example.studentcourse.repository.EnrollmentRepository;
import com.example.studentcourse.repository.StudentRepository;
import com.example.studentcourse.service.EnrollmentService;

import jakarta.transaction.Transactional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService
{
	@Autowired
	private CourseRepository cr;
	@Autowired
	private StudentRepository sr;
	@Autowired
	private EnrollmentRepository er;
	
	
	@Override
	@Transactional
	public Enrollment createEnrollment(long course_Id, long student_Id) 
	{

		
		
	    Student student = sr.findById(student_Id)
	            .orElseThrow(() -> new RuntimeException("Student not found"));

		/* 
		  
		 * What is a Lambda (in Java)?
		 ==	A lambda expression is a short way to write a method without a name.
		 == Lambda makes code: Shorter, Cleaner, More readable. 
		 
		 *  ()-> is called a lambda expression.  
		 *  General lambda syntax this way  (parameters) -> { body }
		   
		 *  .orElseThrow(() -> new RuntimeException("Student not found"));
		 == where 
		    ()	No input parameters
		    ->	“returns / executes”
		    new ResourceNotFoundException("any message")	Object to return
		 
		 *  Functional Interface (Important) 
		==  An interface with exactly one abstract method is called Functional Interface.
		==  A lambda works only with a functional interface.			
		   Examples: Runnable → run() ,  Supplier<T> → get() etc.
				
	    */
	    
	    Course course = cr.findById(course_Id)
	            .orElseThrow(() -> new RuntimeException("Course not found"));

	    Enrollment enrollment = new Enrollment(student, course, LocalDate.now());
	    return er.save(enrollment);

	}
	
	
	@Override
	public List<Enrollment> getAllEnrollment() 
	{
		
		return er.findAll();
	}
	


}
