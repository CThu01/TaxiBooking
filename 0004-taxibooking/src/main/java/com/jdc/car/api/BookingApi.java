package com.jdc.car.api;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.car.model.dto.BookingResultDto;
import com.jdc.car.model.form.BookingForm;
import com.jdc.car.model.output.ApiResponse;

@RestController
@RequestMapping("booking")
public class BookingApi {

	@PostMapping
	public ApiResponse<BookingForm> createBooking(@Validated BookingForm form,BindingResult result){
		return null;
	}
	
	@GetMapping("{bookingId}")
	public ApiResponse<BookingForm> takeBooking(int bookingId){
		return null;
	}
	
	
}
