package com.employee.service;

//Package import
import com.employee.entity.*;
import com.employee.exception.EmployeeServiceException;
import com.employee.repository.*;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;
	
	public List<Employee> getAll() throws EmployeeServiceException{
		return empRepository.getAll();
	}
	
	public ResponseEntity<Object> getEmployee(int employeeId) throws EmployeeServiceException {
		return empRepository.getEmployee(employeeId);
	}
	
	public String add(Employee emp) throws EmployeeServiceException {
		return empRepository.add(emp);
	}

	public String update(int employeeId, Employee emp) {
		return empRepository.update(employeeId, emp);
	}

	public String delete(int employeeId) {
		return empRepository.delete(employeeId);
	}
	
}
