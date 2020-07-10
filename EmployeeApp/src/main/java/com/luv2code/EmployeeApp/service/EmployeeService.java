package com.luv2code.EmployeeApp.service;

import java.util.List;

import com.luv2code.EmployeeApp.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public void save(Employee theEmployee);
	
	public Employee findById(int theId);
	
	public void deleteById(int theId);
}
