package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Department;
import com.example.entity.DepartmentDTO;

import com.example.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
	@Autowired private DepartmentRepository dr;
	@Autowired private  ModelMapper modelMapper;

	@Override
	public void addDepartment(Department department) 
	{
		dr.save(department);
		
	}

	@Override
	public List<Department> getAllDepartmentDetails() 
	{	
		return dr.findAll();
	}

	@Override
	public Department getDepartmentByid(int did)
	{
		
		return dr.findById(did).orElse(null);
	}
/*
	@Override
	public DepartmentDTO getOnlyDepartmentDetails(Department department) 
	{
		DepartmentDTO dto= new DepartmentDTO();
		dto.setDid(department.getDid());
		dto.setHead(department.getHead());
		dto.setName(department.getName());
		return dto;
	}
*/
	
	@Override
	public DepartmentDTO getOnlyDepartmentDetails(Department department) 
	{
		DepartmentDTO dto=modelMapper.map(department,DepartmentDTO.class);
		return dto;
	}
}
