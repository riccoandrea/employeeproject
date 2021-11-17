package com.employee.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
	ERROR_EMPTY_LIST(101, HttpStatus.NOT_FOUND, "Elemento non trovato"),
	ERROR_EMPLOYEE_LIST(102, HttpStatus.NOT_FOUND, "Dipendente già presente"),
	ERROR_EMPTY_FIELD(103, HttpStatus.NOT_FOUND, "Manca un campo");

	private final int code;
	private final HttpStatus status;
	private final String message;
	
	private ErrorCode(int code, HttpStatus status, String message) {
		this.code = code;
		this.status = status;
		this.message = message;
	}
	
	
	
}


