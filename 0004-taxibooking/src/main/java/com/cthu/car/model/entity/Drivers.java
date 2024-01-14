package com.cthu.car.model.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Drivers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginId;
	
	@Column(nullable = false,name = "name")
	private String name;
	
	@Column(nullable = false,name = "password")
	private String password;
	
	@Column(nullable = false,name = "phone")
	private String phone;
	
	@Column(nullable = false)
	private String NRC;
	
	@Column(nullable = false,name = "driver_license")
	private String driverLicense;
	
	@Column(nullable = false)
	private String address;
//	@Column(nullable = false,name = "driver_photo")
	private String driversPhoto;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_brith")
	private LocalDate dateOfBrith;
	
	private String email;
	private int star;
	
	@ManyToOne
	@JoinColumn(nullable = false,name = "township")
	private Township township;	
	
	@OneToOne(mappedBy = "drivers",cascade = {CascadeType.PERSIST,CascadeType.PERSIST})
	private Car car;
	

	
	
	
}
