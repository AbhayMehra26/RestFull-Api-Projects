package com.example.studentcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentcourse.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>
{

}
