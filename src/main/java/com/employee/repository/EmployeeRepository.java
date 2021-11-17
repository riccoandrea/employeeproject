package com.employee.repository;

import com.employee.entity.*;
import com.employee.exception.EmployeeServiceException;
import com.employee.exception.ErrorCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository{
	
	public List<Employee> employee = new ArrayList<>(Arrays.asList(
			new Employee(1, "Mario", "Rossi", "333685548"),
			new Employee(2, "Giuseppe", "Bianchi", "3331468520")		
			));
	
	/**
	 * Displays the list with all employees and 
	 * returns "Empty list" if the list is empty
	 */
	public List<Employee> getAll() throws EmployeeServiceException {
		if(employee.isEmpty()) {
			throw new EmployeeServiceException(ErrorCode.ERROR_EMPTY_LIST);
		}
		return employee;
	}
	
	
	/**
	 * Shows an employee's details for a @param employeeId
	 * @throws EmployeeServiceException check if it is present
	 */
	public ResponseEntity<Object> getEmployee(int employeeId) throws EmployeeServiceException{
		Employee emp = employee.stream().filter(e -> e.getId() == employeeId).findFirst().orElseThrow(()->new EmployeeServiceException(100, "Non c'è nessun dipendente", HttpStatus.NOT_FOUND));
		return ResponseEntity.ok().body(emp);
	}
	
	

	/**
	 * By entering all the fields @param emp
	 * @return Dipendente aggiunto con successo.
	 * @throws EmployeeServiceException if all fields equal to existing employee @return Dipendente già presente or if a field is empty @return "Manca un campo"
	 */
	public String add(Employee emp) throws EmployeeServiceException {
		String firstnameEmp = emp.getFirstname();
		String lastnameEmp = emp.getLastname();
		String telephoneEmp = emp.getTelephone();
		
		if(employee.contains(emp)) {
			throw new EmployeeServiceException(102, "Dipendente già presente", HttpStatus.NOT_FOUND);
		} else if(firstnameEmp.isEmpty() || firstnameEmp == null|| lastnameEmp.isEmpty() || lastnameEmp == null || telephoneEmp.isEmpty() || telephoneEmp == null){ 
			throw new EmployeeServiceException(103, "Manca un campo", HttpStatus.NOT_FOUND);			
		} else employee.add(emp);
			return "Dipendente aggiunto con successo";
	}
	

	 
	/**
	 * Update all fields of a specific employee searched by * @param employeeId
	 * @return "Aggiornamento avvenuto con successo"
	 */
	public String update(int employeeId, Employee emp) {
		int i =0;
		for(Employee employee1 : employee) {
			if(employee1.getId()==employeeId) {
				employee.set(i, emp);
			}
		}
		return "Aggiornamento avvenuto con successo";
		
	}

	/**
	 * Delete specific dependent by * @param employeeId
	 * @return "Cancellato con successo"
	 * @throws EmployeeServiceException 
	 */
	public String delete(int employeeId) {
		employee.remove(employeeId-1) ;
		return "Cancellato con successo";
	}
	
}