package com.cthu.car.model.form;

import java.time.LocalDate;
import java.util.function.Function;

import com.cthu.car.model.dto.DriverInfoDto;
import com.cthu.car.model.entity.Car;
import com.cthu.car.model.entity.CarName;
import com.cthu.car.model.entity.Drivers;
import com.cthu.car.model.entity.Township;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
		@NotNull(message = "Enter Car Type")
		Integer typeOfCar,
		@NotBlank(message = "Enter Password")
		String password,
		@NotBlank(message = "Enter Address")
		String address,
		@NotNull(message = "Select TownShip")
		Integer township,
		@NotNull(message = "aircon serve or not")
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
	
	public Drivers driverEntity(int id,Function<Integer, Township> townShipFun){
		
		var driver = new Drivers();
		
		driver.setLoginId(id);
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

	
	public Car carEntity(int driverId,
			Function<Integer, Drivers> driverFun,
			Function<Integer, CarName> carNameFun) {
		
		var car = new Car();
		car.setCarNo(carNo);
		car.setCarLicense(carLicense);
		car.setAircon(aircon);
		car.setDrivers(driverFun.apply(driverId));
		car.setCarName(carNameFun.apply(typeOfCar));
		
		return car;
	}
	
	public DriverInfoDto getDriverInfoDto(Drivers driver,Car car) {
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

	public Drivers avoideDriverError(int id, Drivers existingDriver, Function<Integer, Township> townshipFun) {
		
		existingDriver.setLoginId(id);
		existingDriver.setName(name);
		existingDriver.setPassword(password);
		existingDriver.setPhone(phone);
		existingDriver.setNRC(NRC);
		existingDriver.setDriverLicense(drivingLicense);
		existingDriver.setAddress(address);
		existingDriver.setDateOfBrith(LocalDate.parse(dob));
		existingDriver.setEmail(email);
		existingDriver.setTownship(townshipFun.apply(township));
		
		return existingDriver;
	}

	public Car avoidCarError(Car existingCar, Drivers existingDriver, Function<Integer, CarName> carNameFunc) {
		
		existingCar.setCarNo(carNo);
		existingCar.setCarLicense(carLicense);
		existingCar.isAircon();
		existingCar.setDrivers(existingDriver);
		existingCar.setCarName(carNameFunc.apply(typeOfCar));
		
		return existingCar;
		
	}
	
	
	
}






