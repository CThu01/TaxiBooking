package com.cthu.car.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.cthu.car.model.entity.Car;

public interface CarRepo extends JpaRepositoryImplementation<Car, Integer>{

}
