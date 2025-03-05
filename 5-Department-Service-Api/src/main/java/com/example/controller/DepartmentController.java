package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Department;
import com.example.entity.DepartmentDTO;
import com.example.service.DepartmentService;

@RestController
@RequestMapping("department")
public class DepartmentController
{
	@Autowired private DepartmentService ds;
	
	@PostMapping("add")
	public ResponseEntity<Department>saveDepartment(@RequestBody Department department)
	{
		ds.addDepartment(department);
		return ResponseEntity.status(HttpStatus.CREATED).body(department);		
	}
	
	@GetMapping("get")
	public ResponseEntity<List<Department>>getAllDepartment()
	{
		List<Department> departmentList =ds.getAllDepartmentDetails();
		if(departmentList!=null)
		return ResponseEntity.status(HttpStatus.OK).body(departmentList);	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();		
	}
	
	@GetMapping("get/{did}")
	public ResponseEntity<DepartmentDTO> getDepartmentInfo(@PathVariable int did)
	{ 
	     Department department =ds.getDepartmentByid(did);
		if(department==null)
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		DepartmentDTO dto=ds.getOnlyDepartmentDetails(department);
		return ResponseEntity.status(HttpStatus.OK).body(dto);	

	}
	

}
