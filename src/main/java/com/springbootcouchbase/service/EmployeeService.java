package com.springbootcouchbase.service;

import java.util.List;

import com.springbootcouchbase.model.Employee;

public interface EmployeeService {

	 List<Employee> getAllEmployees();
	 Employee getEmployeeById(String id);
	 List<Employee> getEmployeeByFirstName(String firstName);
	 void create(Employee emp);
}
