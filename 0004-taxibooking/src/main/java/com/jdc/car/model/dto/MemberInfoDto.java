package com.jdc.car.model.dto;

import java.time.LocalDate;

public record MemberInfoDto(
		int LoginId,
		String name,
		String phone,
		String NRC,
		String address,
		LocalDate dob,
		String memberPhoto
		){

}
