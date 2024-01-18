package com.cthu.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cthu.car.model.entity.Bookings;
import com.cthu.car.model.form.BookingForm;
import com.cthu.car.model.repo.BookingsRepo;

@Service
public class BookingService {

	@Autowired
	private BookingsRepo bookingsRepo;

	public Bookings create(BookingForm form) {
		return null;
	}
}
