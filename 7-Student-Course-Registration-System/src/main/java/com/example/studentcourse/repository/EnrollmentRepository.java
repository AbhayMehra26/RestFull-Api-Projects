package com.example.studentcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentcourse.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>
{

}
