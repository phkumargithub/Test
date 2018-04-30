package com.springbootcouchbase.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcouchbase.model.Employee;
import com.springbootcouchbase.model.MyResponse;
import com.springbootcouchbase.service.EmployeeService;

@RestController
@RequestMapping("/employeeapp")
public class EmployeeController {
	
	@Autowired
    EmployeeService empService;
	

	@RequestMapping(value = "/createemployee", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MyResponse> addEmployee(@Valid @RequestBody Employee employee) {
		MyResponse resp = new MyResponse();
		empService.create(employee);
		if(HttpStatus.OK.is2xxSuccessful()){
			resp.setStatus(HttpStatus.OK.value());
			resp.setMessage("Succesfuly created an employee object");
			return new ResponseEntity<MyResponse>(resp, HttpStatus.OK);
		}
		else{
			resp.setStatus(HttpStatus.OK.value());
			resp.setMessage("Error while creating an employee object");
			return new ResponseEntity<MyResponse>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/employee", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeeFirstName(@RequestParam String firstName) {
		return empService.getEmployeeByFirstName(firstName);		
	}
	
	@RequestMapping(value = "/employee/{id}", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable String id) {
		return empService.getEmployeeById(id);		
	}

}
