package com.luv2code.EmployeeApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.EmployeeApp.entity.Employee;
import com.luv2code.EmployeeApp.entity.Manager;

@Repository
public class EmployeeDAOImpl implements EmployeeDao , ManagerDao{

	//define field for entitymanager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	 public EmployeeDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);
		//execute query and get result list
		List<Employee> employees =  theQuery.getResultList();
		//return the result
		return employees;
	}

	@Override
	public void save(Employee theEmployee) {
		System.out.println("Employeee : "+theEmployee);
		Session curSession = entityManager.unwrap(Session.class);
		curSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
		Session curSession = entityManager.unwrap(Session.class);
		Query theQuery = curSession.createQuery("delete from Employee where id=:empid");
		theQuery.setParameter("empid", theId);
		theQuery.executeUpdate();
	}

	@Override
	public Employee findById(int theId) {
		Session curSession = entityManager.unwrap(Session.class);
		Employee theEmployee = curSession.get(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public Manager saveMgr(Manager theManager) {
		Session curSession = entityManager.unwrap(Session.class);
		curSession.save(theManager);	
		return theManager;
	}

	@Override
	public Manager login(Manager theManager) {
		Session curSession = entityManager.unwrap(Session.class);
		String managerEmail = theManager.email;
		String managerPassword = theManager.password;
		Manager mgr = curSession.get(Manager.class, managerEmail);
		System.out.println("...."+mgr);
		if(mgr.email.equals(managerEmail) && mgr.password.equals(managerPassword)) {
			System.out.println("Login Successful");
		}else {
			System.out.println("Login failed");
		}
		return theManager;
	}

}
