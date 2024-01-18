package com.cthu.car.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cthu.car.model.form.BookingForm;
import com.cthu.car.model.output.ApiResponse;
import com.cthu.car.service.BookingService;

@RestController
@RequestMapping("booking")
public class BookingApi {
	
	@Autowired
	private BookingService bookingService;

	@PostMapping
	public ApiResponse<BookingForm> createBooking(@Validated BookingForm form,BindingResult result){
		bookingService.create(form);
		return null;
	}
	
	@GetMapping("{bookingId}")
	public ApiResponse<BookingForm> takeBooking(int bookingId){
		return null;
	}
	
	
}
