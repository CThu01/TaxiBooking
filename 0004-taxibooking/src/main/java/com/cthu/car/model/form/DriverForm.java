package com.cthu.car.model.form;

import java.time.LocalDate;
import java.util.function.Function;

import com.cthu.car.model.entity.Car;
import com.cthu.car.model.entity.CarName;
import com.cthu.car.model.entity.Drivers;
import com.cthu.car.model.entity.Township;

import jakarta.validation.constraints.NotBlank;

public record DriverForm(
		@NotBlank(message = "Enter name")
		String name,
		@NotBlank(message = "Enter Date Of Birth")
		String dob,
		@NotBlank(message = "Enter Phone No")
		String phone,
		@NotBlank(message = "Enter NRC")
		String NRC,
		@NotBlank(message = "Driving License")
		String drivingLicense,
		@NotBlank(message = "Enter Car No")
		String carNo,
		@NotBlank(message = "Enter Car License")
		String carLicense,
		@NotBlank(message = "Enter Car Type")
		String carType,
		@NotBlank(message = "Enter Password")
		String password,
		@NotBlank(message = "Enter Address")
		String address,
		@NotBlank(message = "Select TownShip")
		Integer township,
		@NotBlank(message = "aircon serve or not")
		Boolean aircon,
		String email
		) {

	public Drivers driverEntity(Function<Integer, Township> townShipFun){
		
		var driver = new Drivers();
		driver.setName(name);
		driver.setPassword(password);
		driver.setPhone(phone);
		driver.setNRC(NRC);
		driver.setDriverLicense(drivingLicense);
		driver.setAddress(address);
		driver.setDateOfBrith(LocalDate.parse(dob));
		driver.setTownship(townShipFun.apply(township));
		
		return driver;
	}
	
	public Car carEntity(Function<Integer, CarName> carNameFun) {
		
		var car = new Car();
		car.setCarNo(carNo);
		car.setCarLicense(carLicense);
		car.setAircon(false);
		
		return car;
	}
	
	
	
	
	
}






