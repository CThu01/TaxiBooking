package com.cthu.car.model.repo;

import org.springframework.stereotype.Repository;

import com.cthu.car.model.entity.Car;
import com.cthu.car.model.entity.Drivers;

@Repository
public interface CarRepo extends BaseRepo<Car, Integer>{

	Car findByDrivers(Drivers existingDriver);

}
