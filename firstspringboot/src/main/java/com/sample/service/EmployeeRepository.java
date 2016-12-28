package com.sample.service;

import org.springframework.data.repository.CrudRepository;

import com.sample.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}
