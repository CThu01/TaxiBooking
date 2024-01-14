package com.cthu.car.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class MembersHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginId;
	
	@Column(nullable = false)	
	private String name;
	
	@Column(nullable = false)	
	private String password;
	
	@Column(nullable = false)	
	private String phone;
	
	@Column(nullable = false)	
	private String NRC;
	
	@Column(nullable = false)	
	private String address;
	
	@Column(nullable = false,name = "user_photo")	
	private String userPhoto;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	private String email;
	private String township;
}
