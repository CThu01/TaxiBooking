package com.jdc.car.utils.exceptions;

import java.util.List;

import org.springframework.validation.BindingResult;

public class ApiValidationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private List<String> errors;
	
	public ApiValidationException(BindingResult result) {
		errors = result.getFieldErrors().stream().map(a -> a.getDefaultMessage()).toList();
	}
	
	public List<String> getErrors(){
		return errors;
	}

}
