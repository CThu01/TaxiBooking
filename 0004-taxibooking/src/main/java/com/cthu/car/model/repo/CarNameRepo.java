package com.cthu.car.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.cthu.car.model.entity.CarName;

public interface CarNameRepo extends JpaRepositoryImplementation<CarName, Integer>{

}
