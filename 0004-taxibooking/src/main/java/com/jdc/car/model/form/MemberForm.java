package com.jdc.car.model.form;

import java.time.LocalDate;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.jdc.car.model.entity.Members;
import com.jdc.car.model.entity.Township;

import jakarta.validation.constraints.NotBlank;


public record MemberForm(
		@NotBlank(message = "Enter name")
		String name,
		@NotBlank(message = "Enter Date of Brith")
		LocalDate dob,
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
	
	public Members entity(PasswordEncoder encoder) {
		
		var member = new Members();
		member.setName(name);
		member.setDateOfBirth(dob);
		member.setPhone(phone);
		member.setNRC(NRC);
		member.setAddress(address);
		
		var tsp = new Township();
		tsp.setName(township);
		
		member.setTownship(tsp);
		member.setPassword(encoder.encode(password));
		member.setEmail(email);
		
		return member;
	}
	

	
	
}













