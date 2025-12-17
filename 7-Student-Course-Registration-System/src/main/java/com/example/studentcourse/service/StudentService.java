package com.example.studentcourse.service;

import java.util.List;

import com.example.studentcourse.entity.Student;

public interface StudentService {

	void createStudent(Student student);

	List<Student> getAllStudent();

}
