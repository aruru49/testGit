package com.sample.service;

import com.sample.model.Employee;
import com.sample.model.EmployeeRequestBean;

public interface EmpService {
	
	public Employee create(EmployeeRequestBean requestBean);
	
	public Employee get(int id);
	
	public boolean delete(int id);

	public Employee update(EmployeeRequestBean requestBean);
	

}
