package com.jdc.car.utils.exceptions;

public class ApiBusinessException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ApiBusinessException(String error) {
		super(error);
	}
}
