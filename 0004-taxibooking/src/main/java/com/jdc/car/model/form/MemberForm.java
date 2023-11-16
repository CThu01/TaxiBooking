package com.jdc.car.model.form;

import jakarta.validation.constraints.NotBlank;

public record MemberForm(
		@NotBlank(message = "Enter name")
		String name,
		@NotBlank(message = "Enter Date of Brith")
		String dob,
		@NotBlank(message = "Enter Phone No")
		String phone,
		@NotBlank(message = "Enter NRC")
		String NRC,
		@NotBlank(message = "Enter Address")
		String address,
		@NotBlank(message = "Select Township")
		String township,
		@NotBlank(message = "Enter password")
		String password,		
		String email

		) {

}
