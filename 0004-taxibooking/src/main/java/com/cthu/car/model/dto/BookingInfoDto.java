package com.cthu.car.model.dto;

public record BookingInfoDto(
		MemberInfoDto member,
		DriverInfoDto driver,
		int price,
		String paymentMethod,
		boolean aircon,
		String pickupPoint,
		String destinationPoint,
		String departureTime,
		String arrivalTime,
		int stars,
		String status
		
		) {

}
