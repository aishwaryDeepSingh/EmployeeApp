package com.luv2code.EmployeeApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.EmployeeApp.dao.ManagerDao;
import com.luv2code.EmployeeApp.entity.Manager;

@Service
public class ManagerSeviceImpl implements ManagerService{

	private ManagerDao managerdao;
	
	@Autowired
	public ManagerSeviceImpl(ManagerDao theManagerDao) {
		managerdao = theManagerDao;
	}
	
	@Override
	@Transactional
	public Manager saveMgr(Manager theManager) {
		return managerdao.saveMgr(theManager);
	}

	@Override
	@Transactional
	public Manager login(Manager theManager) {
		return managerdao.login(theManager);
	}

}
