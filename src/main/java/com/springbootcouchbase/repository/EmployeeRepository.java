package com.springbootcouchbase.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springbootcouchbase.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
	List<Employee> findByFirstName(String firstName);
}
