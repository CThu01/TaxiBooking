package com.cthu.car.model.dto;

import com.cthu.car.model.entity.Drivers;
import com.cthu.car.model.entity.Members;

public record BookingResultDto(
		Members member,
		Drivers driver,
		int price,
		String paymentMethod,
		boolean aricon,
		double pickupPoint,
		double destinationPoint,
		String departureTime,
		String arrivalTime
		
		) {

}
