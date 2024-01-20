package com.cthu.car.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.cthu.car.model.entity.BookingHistory;
import com.cthu.car.model.entity.Bookings;
import com.cthu.car.model.repo.BookingHistoryRepo;

import jakarta.transaction.Transactional;

@Service
public class BookingHistoryEventListener {

	@Autowired
	private BookingHistoryRepo bookingHistoryRepo;
	
	@EventListener
	@Transactional
	public void handle(Bookings booking) {
		
		BookingHistory bookingHistory = new BookingHistory();
		
		if( null == booking.getBookingHistory()) {
			bookingHistory.setVersion(1);
		} else {
			bookingHistory.setVersion(booking.getBookingHistory().size() + 1);
		}
		
		bookingHistory.setBookingId(booking);
		bookingHistory.setFromLocation(booking.getPickupPoint());
		bookingHistory.setToLocation(booking.getDestinationPoint());
		bookingHistory.setPaymentMethod(booking.getPaymentMethod());
		bookingHistory.setAmount(booking.getPrice());
		bookingHistory.setDuration(Duration.between(booking.getDepartureTime(), booking.getArrivalTime()));
		
		
		bookingHistoryRepo.save(bookingHistory);
	}
}
