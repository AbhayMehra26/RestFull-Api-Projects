package com.example.studentcourse.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity  
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  student_Id;
	
	private String studentName;
	private  String email;
	
	 @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	    private List<Enrollment> enrollments;
	   
	
	public Student(String studentName, String email) {
		super();
		this.studentName = studentName;
		this.email = email;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getStudent_Id() {
		return student_Id;
	}

	public void setStudent_Id(Long student_Id) {
		this.student_Id = student_Id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}