package com.cthu.car.model.form;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;

import com.cthu.car.model.entity.Bookings;
import com.cthu.car.model.entity.Bookings.Status;
import com.cthu.car.model.entity.Drivers;
import com.cthu.car.model.entity.Members;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record BookingForm(
		@NotNull(message = "Enter member id")
		int memberId,
		@NotNull(message = "Enter driver id")
		int driverId,
		@NotEmpty(message = "Enter Payment Method")
		String paymentMethod,
		@NotEmpty(message = "Choose Pickup Point")
		String pickupPoint,
		@NotEmpty(message = "Choose Destination Point")
		String destinationPoint,
		@NotEmpty(message = "Enter Car No")
		String carNo,
		@NotEmpty(message = "Enter Booking Time")
		String bookingTime,
		@NotNull(message = "Enter Date")
		String date,
		@NotEmpty(message = "Enter Departure Time")
		String departureTime,
		@NotEmpty(message = "Enter Arriaval Time")
		String arrivalTime,
		@NotNull(message = "aircon or not")
		boolean aircon,
		@NotNull(message = "Enter Price")
		int price,
		int stars,
		@NotEmpty(message = "Choose status")
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
		booking.setDate(LocalDate.parse(date));
		booking.setDepartureTime(LocalDateTime.parse(departureTime));
		booking.setArrivalTime(LocalDateTime.parse(arrivalTime));
		booking.setStatus(Status.valueOf(status));
		booking.setAircon(aircon);
		
		return booking;
	}
	
	
	

}














