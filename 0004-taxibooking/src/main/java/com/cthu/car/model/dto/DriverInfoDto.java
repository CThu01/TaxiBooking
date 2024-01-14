package com.cthu.car.model.dto;

import java.time.LocalDate;

public record DriverInfoDto(
		String name,
		String phone,
		LocalDate dob,
		String NRC,
		String drivingLicense,
		String address,
		String township,
		String carNo,
		String carLicense,
		String typeOfCar,
		String email
		) {
	
	
	
}
