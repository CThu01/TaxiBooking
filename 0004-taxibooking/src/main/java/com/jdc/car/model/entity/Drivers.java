package com.jdc.car.model.entity;

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
import lombok.Data;

@Entity
@Data
public class Drivers {

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
	private String driverLicense;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String driversPhoto;
	@Column(nullable = false)
	private LocalDate dateOfBrith;
	private String email;
	private int star;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Township township;	
	
	@OneToOne(mappedBy = "drivers",cascade = {CascadeType.PERSIST,CascadeType.PERSIST})
	private Car car;
	

	
	
	
}
