package com.jdc.car.utils.exceptions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdc.car.model.output.ErrorResponse;
import com.jdc.car.model.output.ErrorResponse.errorType;

@RestControllerAdvice
public class ExceptionHandling{
	
	private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	ErrorResponse handle(ApiValidationException e) {
		logger.error("ApiValidationException...");
		for(String errorMessage : e.getErrors()) {
			logger.error(errorMessage);
		}
		return new ErrorResponse(errorType.VALIDATION, e.getErrors());
	}

	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	ErrorResponse handle(ApiBusinessException e) {
		logger.error(e.getMessage());
		return new ErrorResponse(errorType.BUSINESS, List.of(e.getMessage()));
	}
	
	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	ErrorResponse handle(Exception e) {
		logger.error(e.getMessage());
		e.printStackTrace();
		return new ErrorResponse(errorType.PLATFORM, List.of(e.getMessage()));
	}
	
	
	
	
	
}
















