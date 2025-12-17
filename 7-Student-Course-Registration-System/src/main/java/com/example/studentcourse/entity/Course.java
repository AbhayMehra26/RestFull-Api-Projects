package com.example.studentcourse.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Course 
{
	@Id
	@GeneratedValue(generator ="course_seq") 
	@SequenceGenerator(name="course_seq",initialValue = 101 ,allocationSize =1 )

	private long course_Id;	
	private String courseName;
	private String duration;
	
	
	 @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	 private List<Enrollment> enrollments;
	   
	
	public Course(String courseName, String duration) {
		super();
		this.courseName = courseName;
		this.duration = duration;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public long getCourse_Id() {
		return course_Id;
	}

	public void setCourse_Id(long course_Id) {
		this.course_Id = course_Id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
	

}
