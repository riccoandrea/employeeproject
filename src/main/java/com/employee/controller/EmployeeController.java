package com.employee.controller;

import com.employee.entity.*;
import com.employee.exception.EmployeeServiceException;
import com.employee.service.*;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@GetMapping("/all")
	@ApiOperation(code = 400, value = "get all", notes = "get all employee")
	public List<Employee> getAll() throws EmployeeServiceException {
		return empService.getAll();
	}
	
	@GetMapping("/{employeeId}")
	@ApiOperation(code = 400, value = "get employee", notes = "get employee by id")
	public ResponseEntity<Object> getEmployee(@PathVariable int employeeId) throws EmployeeServiceException {
		return empService.getEmployee(employeeId);
	}
	
	@PostMapping("/add")
	@ApiOperation(code = 400, value = "add employee", notes = "add employee")
	public String add(@RequestBody Employee emp) throws EmployeeServiceException{
		return empService.add(emp);
	}
	
	@PutMapping("/update/{employeeId}")
	@ApiOperation(code = 400, value = "update employee", notes = "update employee by id")
	public String edit(@PathVariable int employeeId, @RequestBody Employee emp){
		return empService.update(employeeId, emp);
	}
	
	@DeleteMapping("/delete/{employeeId}")
	@ApiOperation(code = 400, value = "delete employee", notes = "delete employee by id")
	public String delete(@PathVariable int employeeId){
		return empService.delete(employeeId);
	}
}
