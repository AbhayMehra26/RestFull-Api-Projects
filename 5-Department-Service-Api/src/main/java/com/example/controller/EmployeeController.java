package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("employee-info")
public class EmployeeController 
{
	@Autowired private EmployeeService es;
	
	@PostMapping("employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		es.saveEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}
	
	@GetMapping("get")
	public ResponseEntity<List<Employee>>getAllDepartment()
	{
		List<Employee> employeeList =es.getAllemployeeDetails();
		if(employeeList!=null)
		return ResponseEntity.status(HttpStatus.OK).body(employeeList);	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();		
	}

}
