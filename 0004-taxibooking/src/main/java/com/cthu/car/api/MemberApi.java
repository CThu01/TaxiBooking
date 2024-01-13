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

import com.cthu.car.model.dto.BookingHistoryDto;
import com.cthu.car.model.dto.MemberInfoDto;
import com.cthu.car.model.form.LoginForm;
import com.cthu.car.model.form.MemberForm;
import com.cthu.car.model.output.ApiResponse;
import com.cthu.car.service.MemberService;

@RestController
@RequestMapping("member")
public class MemberApi {

	@Autowired
	MemberService memberService;
	
	@PostMapping("signup")
	public ApiResponse<String> signup(@Validated MemberForm form,BindingResult result) {
		return new ApiResponse<String>(true, memberService.create(form));
	}
	
	@PostMapping
	public ApiResponse<MemberInfoDto> login(@Validated LoginForm form,BindingResult result){
		return null;
	}
	
	@GetMapping
	public List<ApiResponse<BookingHistoryDto>> getBookingHistroy(
			@RequestParam String name,
			@RequestParam Optional<LocalDate> from,
			@RequestParam Optional<LocalDate> to
			){
		return null;
	}
	
	@GetMapping("profile")
	public ApiResponse<MemberInfoDto> getProfile(@RequestParam String name){
		return null;
	}
	
	@PutMapping("update/{id}")
	public ApiResponse<MemberInfoDto> updateProfile(@PathVariable int id,@Validated MemberForm form,BindingResult result){
		return null;
	}
	
	

	
	
	
}











