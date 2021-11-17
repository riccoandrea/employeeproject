package com.employee.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value=EmployeeServiceException.class)
	public ResponseEntity<ErrorResponse> exceptionEmployeeService(EmployeeServiceException exe){
		int code = exe.getCode();
		String message = exe.getMessage();

		ErrorResponse error = new ErrorResponse(code, message);
		return new ResponseEntity<ErrorResponse>(error, exe.getStatus());
	}
}
