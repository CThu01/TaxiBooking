package com.cthu.car.model.dto;

public record BookingHistoryInfoDto(
		BookingInfoDto bookingInfoDto,
		String fromLocation,
		String toLocation,
		String paymentMethod,
		int amount,
		String duration,
		int version
		) {

}
