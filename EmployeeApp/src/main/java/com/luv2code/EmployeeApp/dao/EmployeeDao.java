package com.luv2code.EmployeeApp.dao;

import java.util.List;

import com.luv2code.EmployeeApp.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	public void save(Employee theEmployee);
	public void deleteById(int theId);
	public Employee findById(int theId);
}
