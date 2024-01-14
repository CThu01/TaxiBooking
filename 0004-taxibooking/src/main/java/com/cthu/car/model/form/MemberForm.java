package com.cthu.car.model.form;

import java.time.LocalDate;
import java.util.function.Function;

import com.cthu.car.model.entity.Members;
import com.cthu.car.model.entity.Township;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


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
		@NotNull(message = "Select Township")
		Integer township,
		@NotBlank(message = "Enter password")
		String password,		
		String email
		) {
	
	public Members entity(Function<Integer, Township> townshipFun) {
		
		var member = new Members();
		member.setName(name);
		member.setDateOfBirth(LocalDate.parse(dob));
		member.setPhone(phone);
		member.setNRC(NRC);
		member.setPassword(password);
		member.setEmail(email);
		member.setAddress(address);
		member.setTownship(townshipFun.apply(township));
		
		return member;
	}
	
	public Members updateEntity(int id,Function<Integer, Township> townshipFun) {
		
		var member = new Members();
		member.setLoginId(id);
		member.setName(name);
		member.setDateOfBirth(LocalDate.parse(dob));
		member.setPhone(phone);
		member.setNRC(NRC);
		member.setPassword(password);
		member.setEmail(email);
		member.setAddress(address);
		member.setTownship(townshipFun.apply(township));
		
		return member;
	}

	

	
	
}













