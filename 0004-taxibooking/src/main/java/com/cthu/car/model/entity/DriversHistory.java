package com.cthu.car.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriversHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverHistoryId;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Drivers driverId;
	
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
	
//	@Column(nullable = false)
	private String driverPhoto;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private LocalDate dateOfBrith;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String township;
	
	@Column(nullable = false)
	private String carNo;
	
	@Column(nullable = false)
	private String carLicense;
	
	@Column(nullable = false)
	private boolean aircon;
	
	@Column(nullable = false)
	private String carName;
	
	private int star;

}
