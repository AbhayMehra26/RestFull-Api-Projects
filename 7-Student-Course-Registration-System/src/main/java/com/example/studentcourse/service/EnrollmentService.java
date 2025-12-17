package com.example.studentcourse.service;

import java.util.List;

import com.example.studentcourse.entity.Enrollment;

public interface EnrollmentService 
{

	Enrollment createEnrollment(long course_Id, long student_Id);

	List<Enrollment> getAllEnrollment();


}
