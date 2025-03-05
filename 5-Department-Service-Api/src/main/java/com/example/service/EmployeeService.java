package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeService 
{

	void saveEmployee(Employee employee);

	List<Employee> getAllemployeeDetails();

}
