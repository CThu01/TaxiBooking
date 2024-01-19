package com.cthu.car.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.cthu.car.model.entity.Car;

@Repository
public interface CarRepo extends JpaRepositoryImplementation<Car, Integer>{

}
