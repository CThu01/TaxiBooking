package com.cthu.car.model.dto;

public record DriverInfoDto(
		String name,
		String phone,
		String dob,
		String NRC,
		String drivingLicense,
		String address,
		String township,
		String carNo,
		String carLicense,
		String carType,
		String email
		) {
	
}
