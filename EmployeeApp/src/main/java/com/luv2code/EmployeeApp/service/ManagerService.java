package com.luv2code.EmployeeApp.service;

import com.luv2code.EmployeeApp.entity.Manager;

public interface ManagerService {

	public Manager saveMgr(Manager theManager);
	
	public Manager login(Manager theManager);
}
