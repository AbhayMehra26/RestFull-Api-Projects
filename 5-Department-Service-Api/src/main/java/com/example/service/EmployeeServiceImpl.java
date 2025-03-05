package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired private EmployeeRepository er;

	@Override
	public void saveEmployee(Employee employee) 
	{
		er.save(employee);

		
	}

	@Override
	public List<Employee> getAllemployeeDetails() 
	{
		
		return er.findAll();
	}
}
