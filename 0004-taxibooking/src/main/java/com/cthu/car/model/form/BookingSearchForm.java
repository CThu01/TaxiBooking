package com.cthu.car.model.form;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cthu.car.model.entity.BookingHistory;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record BookingSearchForm(
		String name,
		LocalDate dateFrom,
		LocalDate dateTo,
		int priceFrom,
		int priceTo,
		String carNo,
		String carLicense,
		String driverLicense
		) {

	public Predicate[] where(CriteriaBuilder cb, Root<BookingHistory> root) {

		List<Predicate> predicateList = new ArrayList<Predicate>();
		var booking = root.join("bookingId",JoinType.LEFT);
		
		if( null != name && !name.isEmpty()) {
			
			var namePredicate = cb.or(
					cb.like(cb.lower(booking.get("memberId").get("name")), "%".concat(name.toLowerCase()).concat("%")),
					cb.like(cb.lower(booking.get("driverId").get("name")), "%".concat(name.toLowerCase()).concat("%"))
					);
			predicateList.add(namePredicate);
		}
		
		if( null != dateFrom) {
			var predicate = cb.greaterThanOrEqualTo(booking.get("date"), dateFrom);
			predicateList.add(predicate);
		}
		
		if( null != dateTo) {
			var predicate = cb.lessThanOrEqualTo(booking.get("date"), dateTo);
			predicateList.add(predicate);
		}
		
		if( priceFrom != 0) {
			var predicate = cb.greaterThanOrEqualTo(booking.get("price"), priceFrom);
			predicateList.add(predicate);
		}
		
		if( priceTo != 0) {
			var predicate = cb.lessThanOrEqualTo(booking.get("price"), priceTo);
			predicateList.add(predicate);
		}
		
		if( null != carNo) {
			var predicate = cb.like(booking.get("driverId").get("car").get("carNo"), carNo);
			predicateList.add(predicate);
		}
		
		if( null != carLicense) {
			var predicate = cb.like(booking.get("driverId").get("car").get("carLicense"), carLicense);
			predicateList.add(predicate);
		}

		if( null != driverLicense) {
			var predicate = cb.like(booking.get("driverId").get("driverLicense"), driverLicense);
			predicateList.add(predicate);
		}
		
		return predicateList.toArray(size -> new Predicate[size]);
	}
	
	
	
	

}















