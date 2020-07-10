package com.luv2code.EmployeeApp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.EmployeeApp.dao.EmployeeDao;
import com.luv2code.EmployeeApp.entity.Employee;
import com.luv2code.EmployeeApp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		System.out.println("Employee Details are : "+theEmployee);
		theEmployee.setEmpid(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@PutMapping("/employeeupd")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId){
		Employee tempEmployee = employeeService.findById(employeeId);
		if(tempEmployee == null) {
			throw new RuntimeException("Employee id not found :"+employeeId);
		}
		employeeService.deleteById(employeeId);
		return "Deleted employee id - "+employeeId;
	}
	
}
