package com.cthu.car.model.dto;

import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Selection;

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

	public static Selection<?> select(Path<Object> path) {
		// TODO Auto-generated method stub
		return null;
	}

}
