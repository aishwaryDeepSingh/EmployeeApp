package com.luv2code.EmployeeApp.dao;

import com.luv2code.EmployeeApp.entity.Manager;

public interface ManagerDao {

	public Manager saveMgr(Manager theManager);
	public Manager login(Manager theManager);
}
