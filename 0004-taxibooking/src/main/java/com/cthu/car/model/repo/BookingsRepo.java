package com.cthu.car.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.cthu.car.model.entity.Bookings;

public interface BookingsRepo extends JpaRepositoryImplementation<Bookings, Integer>{

}
