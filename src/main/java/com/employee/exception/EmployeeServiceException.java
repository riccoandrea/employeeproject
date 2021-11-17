package com.employee.exception;

import org.springframework.http.HttpStatus;

public class EmployeeServiceException extends Exception {
	
	private int code;
	private String message;
	private HttpStatus status;
	
	public EmployeeServiceException(int code, String message, HttpStatus status) {
		super();
		this.code = code;
		this.message = message;
		this.status = status;
	}

	public int getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}


	public HttpStatus getStatus() {
		return status;
	}

	public EmployeeServiceException(ErrorCode errorEmptyList) {
		super();
	}

	public EmployeeServiceException(final String message) {
		super(message);
	}
	
	
}
