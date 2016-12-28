package com.sample.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.Employee;
import com.sample.model.EmployeeRequestBean;
import com.sample.model.SampleRequestBean;
import com.sample.service.impl.EmpServiceImpl;
import com.sample.service.impl.SampleServiceImpl;

@RestController
@RequestMapping(path = "/addition")
public class SampleController {

	@Autowired
	SampleServiceImpl sampleService;

	@Autowired
	EmpServiceImpl empService;

	@RequestMapping(method = RequestMethod.POST, produces = { APPLICATION_JSON_VALUE,
			APPLICATION_JSON_UTF8_VALUE }, consumes = { APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<Integer> add(@RequestBody SampleRequestBean requestBean) {

		System.out.println("entered into add method");

		int first = requestBean.getFirst();

		int second = requestBean.getSecond();

		Integer result = sampleService.add(first, second);

		return new ResponseEntity<Integer>(result, HttpStatus.ACCEPTED);
	}

	@RequestMapping(path = "employee", method = RequestMethod.POST, produces = { APPLICATION_JSON_VALUE,
			APPLICATION_JSON_UTF8_VALUE }, consumes = { APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<Integer> create(@RequestBody EmployeeRequestBean requestBean) {

		System.out.println("entered into employee method");

		Employee emp = empService.create(requestBean);

		return new ResponseEntity<Integer>(emp.getId(), HttpStatus.ACCEPTED);
	}

	@RequestMapping(path = "employee", method = RequestMethod.PUT, produces = { APPLICATION_JSON_VALUE,
			APPLICATION_JSON_UTF8_VALUE }, consumes = { APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<String> update(@RequestBody EmployeeRequestBean requestBean) {

		System.out.println("entered into employee update method");

		Employee emp = empService.update(requestBean);

		return new ResponseEntity<String>("{\"response\":\"Employee Updated Successfully\"}", HttpStatus.ACCEPTED);
	}

	@RequestMapping(path = "employee", method = RequestMethod.GET, produces = { APPLICATION_JSON_VALUE,
			APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<EmployeeRequestBean> get(@RequestParam int id) {

		System.out.println("entered into employee get method");

		Employee emp = empService.get(id);

		EmployeeRequestBean bean = new EmployeeRequestBean();

		bean.setEmpId(emp.getId());

		bean.setEmpName(emp.getName());

		bean.setEmpSal(emp.getSalary());

		return new ResponseEntity<EmployeeRequestBean>(bean, HttpStatus.ACCEPTED);
	}

	@RequestMapping(path = "employee", method = RequestMethod.DELETE, produces = { APPLICATION_JSON_VALUE,
			APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<Boolean> create(@RequestParam int id) {

		System.out.println("entered into employee delete method");

		boolean flag = empService.delete(id);

		return new ResponseEntity<Boolean>(flag, HttpStatus.ACCEPTED);
	}

}
