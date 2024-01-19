package com.cthu.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cthu.car.model.dto.BookingInfoDto;
import com.cthu.car.model.entity.Bookings;
import com.cthu.car.model.form.BookingForm;
import com.cthu.car.model.repo.BookingsRepo;
import com.cthu.car.model.repo.DriversRepo;
import com.cthu.car.model.repo.MembersRepo;
import com.cthu.car.utils.exceptions.ApiBusinessException;

@Service
public class BookingService {

	@Autowired
	private BookingsRepo bookingsRepo;
	
	@Autowired
	private MembersRepo memberRepo;
	
	@Autowired
	private DriversRepo driverRepo;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private DriverService driverService;
	
	public BookingInfoDto create(BookingForm form) {
		
		Bookings booking = bookingsRepo.save(form.getBooking(
					id -> memberRepo.findById(id).orElseThrow(() -> new ApiBusinessException("Invalid Member Id"))
				   ,id -> driverRepo.findById(id).orElseThrow(() -> new ApiBusinessException("Invalid Driver Id"))
				   ));
		return getBookingInfoDto(booking);
	}
	
	private BookingInfoDto getBookingInfoDto(Bookings booking) {
				
		return new BookingInfoDto(
					memberService.getProfile(booking.getMemberId().getLoginId()), 
					driverService.getProfileById(booking.getDriverId().getLoginId()), 
					booking.getPrice(), 
					booking.getPaymentMethod(),
					booking.isAircon(), 
					booking.getPickupPoint(),
					booking.getDestinationPoint(), 
					booking.getDepartureTime().toString(), 
					booking.getArrivalTime().toString(), 
					booking.getStars(),
					booking.getStatus().toString());
	}
	

}
