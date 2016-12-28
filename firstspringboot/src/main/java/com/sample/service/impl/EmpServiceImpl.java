package com.sample.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.model.Employee;
import com.sample.model.EmployeeRequestBean;
import com.sample.service.EmpService;
import com.sample.service.EmployeeRepository;

@Transactional
@Component("empService")
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmployeeRepository empRepo;

	@Override
	public Employee create(EmployeeRequestBean requestBean) {

		Employee emp = new Employee();

		emp.setName(requestBean.getEmpName());

		emp.setSalary(requestBean.getEmpSal());

		empRepo.save(emp);

		return emp;
	}

	@Override
	public Employee update(EmployeeRequestBean requestBean) {

		Employee emp = empRepo.findOne(requestBean.getEmpId());

		if (requestBean.getEmpName() != null) {
			emp.setName(requestBean.getEmpName());

		}

		if (requestBean.getEmpSal() != null) {
			emp.setSalary(requestBean.getEmpSal());
		}
		
		empRepo.save(emp);
		
		return emp;
	}

	@Override
	public Employee get(int id) {
		
		Employee emp = empRepo.findOne(id);
		
		return emp;
	}

	@Override
	public boolean delete(int id) {

		Employee emp = empRepo.findOne(id);

		empRepo.delete(emp);
		
		return true;
	}

}
