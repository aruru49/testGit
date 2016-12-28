package com.sample.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import com.sample.model.Employee;
import com.sample.model.EmployeeRequestBean;
import com.sample.service.EmployeeRepository;

@RunWith(PowerMockRunner.class)
public class EmpServiceImplTest {

	@InjectMocks
	EmpServiceImpl service;

	@Mock
	EmployeeRepository empRepo;

	@Mock
	EmployeeRequestBean requestBean;

	@Mock
	Employee emp;

	@Test
	public void testCreate() {

		Mockito.when(empRepo.save(emp)).thenReturn(emp);

		service.create(requestBean);

		Assert.assertNotNull(emp);

	}

}
