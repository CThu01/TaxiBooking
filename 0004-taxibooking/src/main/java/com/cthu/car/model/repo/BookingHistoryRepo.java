package com.cthu.car.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.cthu.car.model.entity.BookingHistory;

public interface BookingHistoryRepo extends JpaRepositoryImplementation<BookingHistory, Integer>{

}
