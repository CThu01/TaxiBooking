package com.cthu.car.model.form;

public record BookingForm(
		String memberName,
		String driverName,
		String paymentMethod,
		String pickupPoint,
		String destinationPoint,
		String carNo,
		boolean aircon,
		int price
		
		) {

}
