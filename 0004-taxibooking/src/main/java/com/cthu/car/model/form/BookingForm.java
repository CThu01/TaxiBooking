package com.cthu.car.model.form;

import java.time.LocalDateTime;
import java.util.function.Function;

import com.cthu.car.model.entity.Bookings;
import com.cthu.car.model.entity.Bookings.Status;
import com.cthu.car.model.entity.Drivers;
import com.cthu.car.model.entity.Members;

public record BookingForm(
		int memberId,
		int driverId,
		String paymentMethod,
		String pickupPoint,
		String destinationPoint,
		String carNo,
		String bookingTime,
		String departureTime,
		String arrivalTime,
		boolean aircon,
		int price,
		int stars,
		String status
		) {
	
	
	public Bookings getBooking(
			Function<Integer, Members> memberFun,
			Function<Integer, Drivers> driverFun
			) {
		
		Bookings booking = new Bookings();
		booking.setMemberId(memberFun.apply(memberId));
		booking.setDriverId(driverFun.apply(driverId));
		booking.setPaymentMethod(paymentMethod);
		booking.setStars(stars);
		booking.setPickupPoint(pickupPoint);
		booking.setDestinationPoint(destinationPoint);
		booking.setBookingTime(LocalDateTime.parse(bookingTime));
		booking.setDepartureTime(LocalDateTime.parse(departureTime));
		booking.setArrivalTime(LocalDateTime.parse(arrivalTime));
		booking.setStatus(Status.valueOf(status));
		booking.setAircon(aircon);
		
		return booking;
	}
	
	
	

}














