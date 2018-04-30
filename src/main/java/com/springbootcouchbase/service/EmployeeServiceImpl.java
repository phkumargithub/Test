package com.springbootcouchbase.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootcouchbase.model.Employee;
import com.springbootcouchbase.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emplList = new ArrayList<Employee>();
		Iterator<Employee> iter = employeeRepo.findAll().iterator();
		while(iter.hasNext()){
			emplList.add(iter.next());
		}
		return emplList;

	}

	@Override
	public Employee getEmployeeById(String id) {
		return employeeRepo.findOne(id);	
		}

	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		return employeeRepo.findByFirstName(firstName);
	}

	@Override
	public void create(Employee emp) {
		employeeRepo.save(emp);
		
	}

}
