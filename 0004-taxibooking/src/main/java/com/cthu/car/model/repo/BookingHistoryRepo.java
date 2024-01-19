package com.cthu.car.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.cthu.car.model.entity.BookingHistory;

@Repository
public interface BookingHistoryRepo extends JpaRepositoryImplementation<BookingHistory, Integer>{

}
