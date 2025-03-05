package com.example.service;

import java.util.List;

import com.example.entity.Department;
import com.example.entity.DepartmentDTO;

public interface DepartmentService {

	void addDepartment(Department department);

	List<Department> getAllDepartmentDetails();

	Department getDepartmentByid(int did);

	DepartmentDTO getOnlyDepartmentDetails(Department department);

}
