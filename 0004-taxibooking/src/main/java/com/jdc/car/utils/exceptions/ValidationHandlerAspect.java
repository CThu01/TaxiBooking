package com.jdc.car.utils.exceptions;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

@Aspect
@Configuration
public class ValidationHandlerAspect {

	@Pointcut(value ="@within(org.springframework.web.bind.annotation.RestController)")
	void apiErrorResult() {}
	
	@Before(value = "apiErrorResult() and args(..,result)",argNames = "result")
	public void adviceWork(BindingResult result) {
		if(result.hasErrors()) {
			throw new ApiValidationException(result);
		}
	}
}
