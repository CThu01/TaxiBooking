package com.jdc.car.api;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.car.model.dto.ApiResponse;
import com.jdc.car.model.dto.MemberBookingHistroyDto;
import com.jdc.car.model.dto.MemberInfoDto;
import com.jdc.car.model.form.LoginForm;
import com.jdc.car.model.form.MemberForm;

@RestController
@RequestMapping("member")
public class MemberApi {

	@PostMapping("signup")
	public ApiResponse<Integer> signup(@Validated MemberForm form,BindingResult result) {
		return null;
	}
	
	@PostMapping
	public ApiResponse<MemberInfoDto> login(@Validated LoginForm form,BindingResult result){
		return null;
	}
	
	@RequestMapping
	public List<ApiResponse<MemberBookingHistroyDto>> getBookingHistroy(
			@RequestParam String name,
			@RequestParam Optional<LocalDate> from,
			@RequestParam Optional<LocalDate> to
			){
		return null;
	}
	
	@PutMapping("{id}")
	public ApiResponse<MemberInfoDto> updateProfile(@PathVariable int id,@Validated MemberForm form,BindingResult result){
		return null;
	}
	
	
	
	
	
}











