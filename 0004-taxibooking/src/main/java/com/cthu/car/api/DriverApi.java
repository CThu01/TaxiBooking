package com.cthu.car.api;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cthu.car.model.dto.BookingHistoryInfoDto;
import com.cthu.car.model.dto.DriverInfoDto;
import com.cthu.car.model.form.DriverForm;
import com.cthu.car.model.form.LoginForm;
import com.cthu.car.model.output.ApiResponse;
import com.cthu.car.service.DriverService;

@RestController
@RequestMapping("driver")
public class DriverApi {
	
	@Autowired
	private DriverService driverService;

	@PostMapping("signup")
	public ApiResponse<DriverInfoDto> signup(@Validated DriverForm form,BindingResult result){
		return ApiResponse.success(driverService.create(form));
	}
	
	@PostMapping
	public ApiResponse<DriverInfoDto> login(@Validated LoginForm form,BindingResult result){
		return null;
	}
	
	@GetMapping
	public List<ApiResponse<BookingHistoryInfoDto>> getBookingHistory(
			@RequestParam String name,
			@RequestParam Optional<LocalDate> from,
			@RequestParam Optional<LocalDate> to
			){
		return null;
	}
	
	@GetMapping("prfile/{id}")
	public ApiResponse<DriverInfoDto> getProfile(@PathVariable int id){
		
		return ApiResponse.success(driverService.getProfileById(id));
	}
	
	@PutMapping("update/{id}")
	public ApiResponse<DriverInfoDto> updateProfile(@PathVariable int id,@Validated DriverForm form,BindingResult result){
		
		return ApiResponse.success(driverService.update(id, form));
	}
	
}
