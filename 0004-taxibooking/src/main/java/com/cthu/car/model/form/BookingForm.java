package com.cthu.car.model.form;

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
		int price
		
		) {

}
