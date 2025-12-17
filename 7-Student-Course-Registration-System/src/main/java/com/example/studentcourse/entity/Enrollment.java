package com.example.studentcourse.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Enrollment 
{
	@Id
	@GeneratedValue(generator  = "enrollment_seq")
	@SequenceGenerator(name = "enrollment_seq" ,initialValue = 1000,allocationSize = 1)
	private long enrollment_Id;
	
	@ManyToOne
    @JoinColumn(name="Student_Id")
	private Student student;
	
	@ManyToOne
    @JoinColumn(name="Course_Id")
	private Course course;
	
	private LocalDate enrollmentDate;
	
	

	public Enrollment(Student student, Course course, LocalDate enrollmentDate) {
		super();
		this.student = student;
		this.course = course;
		this.enrollmentDate = enrollmentDate;
	}

	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getEnrollment_Id() {
		return enrollment_Id;
	}

	public void setEnrollment_Id(long enrollment_Id) {
		this.enrollment_Id = enrollment_Id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	
	

}
