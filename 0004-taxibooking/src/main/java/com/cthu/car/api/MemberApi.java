package com.cthu.car.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.cthu.car.model.dto.MemberInfoDto;
import com.cthu.car.model.form.BookingSearchForm;
import com.cthu.car.model.form.LoginForm;
import com.cthu.car.model.form.MemberForm;
import com.cthu.car.model.output.ApiResponse;
import com.cthu.car.service.BookingService;
import com.cthu.car.service.MemberService;

@RestController
@RequestMapping("member")
public class MemberApi {

	@Autowired
	MemberService memberService;
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("signup")
	public ApiResponse<String> signup(@Validated MemberForm form,BindingResult result) {
		return new ApiResponse<String>(true, memberService.create(form));
	}
	
	@PostMapping
	public ApiResponse<MemberInfoDto> login(@Validated LoginForm form,BindingResult result){
		return null;
	}
	
	@GetMapping("profile/bookingHistory/{id}")
	public ApiResponse<List<BookingHistoryInfoDto>> getAllMemberBookingHistory(@PathVariable int id){
		
		return ApiResponse.success(bookingService.getAllBookingHistory(id,"member"));
	}
	
	@GetMapping
	public Page<BookingHistoryInfoDto> getBookingHistroy(
			BookingSearchForm form,
			@RequestParam(required = false,defaultValue = "0") int page,
			@RequestParam(required = false,defaultValue = "10") int size
			){
		return bookingService.search(form,page,size);
	}
	
	
	@GetMapping("profile/{id}")
	public ApiResponse<Object> getProfileById(@PathVariable int id){
		var member = memberService.getProfile(id);
		return ApiResponse.success(member);
	}
	
	@PutMapping("update/{id}")
	public ApiResponse<MemberInfoDto> updateProfile(@PathVariable int id,@Validated MemberForm form,BindingResult result){
		return ApiResponse.success(memberService.profileUpdate(id, form));
	}
	
	

	
	
	
}











