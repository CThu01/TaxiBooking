package com.jdc.car.api;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.car.model.dto.ApiResponse;
import com.jdc.car.model.dto.DriverInfoDto;
import com.jdc.car.model.form.DriverForm;
import com.jdc.car.model.form.LoginForm;

@RestController
@RequestMapping("driver")
public class DriverApi {

	public ApiResponse<Integer> singup(@Validated DriverForm form,BindingResult result){
		return null;
	}
	
	public ApiResponse<DriverInfoDto> login(@Validated LoginForm form,BindingResult result){
		return null;
	}
	
}
