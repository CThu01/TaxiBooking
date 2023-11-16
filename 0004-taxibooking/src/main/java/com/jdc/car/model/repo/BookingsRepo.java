package com.jdc.car.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.car.model.entity.Bookings;

public interface BookingsRepo extends JpaRepositoryImplementation<Bookings, Integer>{

}
