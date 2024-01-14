package com.cthu.car.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Car {

	@Id
	private int id;
	
	@Column(nullable = false,unique = true,name = "car_no")
	private String carNo;
	
	@Column(nullable = false,unique = true,name = "car_license")
	private String carLicense;
	
	@Column(nullable = false)
	private boolean aircon;
	
	@OneToOne
	@MapsId
	private Drivers drivers;
	
	@ManyToOne
	@JoinColumn(nullable = false,name = "car_name")
	private CarName carName;
}
