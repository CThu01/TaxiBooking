package com.cthu.car.model.entity;

import java.time.LocalDate;
import java.util.List;

import com.cthu.car.model.dto.DriverInfoDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
//	@Column(nullable = false)
	private String email;
	private int star;
	
	@ManyToOne
	@JoinColumn(nullable = false,name = "township")
	private Township township;	
	
	@OneToOne(mappedBy = "drivers",cascade = {CascadeType.ALL})
	private Car car;
	
	@OneToMany(mappedBy = "driverId")
	private List<DriversHistory> driverHistory;
	
	public DriverInfoDto resultDriverInfoDto(Drivers driver,Car car) {
		return new DriverInfoDto(
				driver.getName(), 
				driver.getPhone(), 
				driver.getDateOfBrith(), 
				driver.getNRC(), 
				driver.getDriverLicense(), 
				driver.getAddress(), 
				driver.getTownship().getName(), 
				car.getCarNo(), 
				car.getCarLicense(), 
				car.getCarName().getName(), 
				driver.getEmail());
	}

	
	
	
}
