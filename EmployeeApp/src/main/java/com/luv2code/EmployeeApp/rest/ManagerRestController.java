package com.luv2code.EmployeeApp.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.EmployeeApp.entity.Manager;
import com.luv2code.EmployeeApp.service.ManagerService;

@RestController
@RequestMapping("/api1")
public class ManagerRestController {

	Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	private ManagerService managerService;
	
	@Autowired
	 public ManagerRestController(ManagerService theManagerService) {
		managerService = theManagerService;
	}
	
	@PostMapping("/manager")
	public Manager addManager(@RequestBody Manager theManager) {
		managerService.saveMgr(theManager);
		return theManager;
	}
	
	@PostMapping("/login")
	public Manager login(@RequestBody Manager theManager) {
	logger.info(theManager.password);
		System.out.println(theManager.email);
		managerService.login(theManager);
		return theManager;
	}
}
