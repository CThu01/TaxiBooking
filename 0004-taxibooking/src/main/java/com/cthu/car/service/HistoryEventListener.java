package com.cthu.car.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.cthu.car.model.entity.BookingHistory;
import com.cthu.car.model.entity.Bookings;
import com.cthu.car.model.entity.Car;
import com.cthu.car.model.entity.Drivers;
import com.cthu.car.model.entity.DriversHistory;
import com.cthu.car.model.entity.Members;
import com.cthu.car.model.entity.MembersHistory;
import com.cthu.car.model.repo.BookingHistoryRepo;
import com.cthu.car.model.repo.CarRepo;
import com.cthu.car.model.repo.DriverHistoryRepo;
import com.cthu.car.model.repo.MemberHistoryRepo;

import jakarta.transaction.Transactional;

@Service
public class HistoryEventListener {

	@Autowired
	private BookingHistoryRepo bookingHistoryRepo;
	
	@Autowired
	private MemberHistoryRepo memberHistoryRepo;
	
	@Autowired
	private DriverHistoryRepo driverHistoryRepo;
	
	@Autowired
	private CarRepo carRepo;
	
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
	
	@EventListener
	@Transactional
	public void handle(Members member) {
		
		MembersHistory memberHistory = new MembersHistory();
		
		if(null == member.getMemberHistory()) {
			System.out.println("Het Member null is working !!!! : ");
			memberHistory.setVersion(1);
		} else {
			System.out.println("Het Member stop here !!!! : " + member.getMemberHistory().size());
			memberHistory.setVersion(member.getMemberHistory().size() + 1);
		}
		
		memberHistory.setMemberId(member);	
		memberHistory.setName(member.getName());
		memberHistory.setPassword(member.getPassword());
		memberHistory.setPhone(member.getPhone());
		memberHistory.setNRC(member.getNRC());
		memberHistory.setAddress(member.getAddress());
		memberHistory.setTownship(member.getTownship().getName());
		memberHistory.setDateOfBirth(member.getDateOfBirth());
		
		memberHistoryRepo.save(memberHistory);;
	}
	
	@EventListener
	@Transactional
	public void handle(Drivers driver) {
		
		DriversHistory driverHistory = new DriversHistory();
		
		if(null == driver.getDriverHistory()) {
			driverHistory.setVersion(1);
		} else {
			System.out.println("Hey Driver Stop Here !!!!! : " + driver.getDriverHistory().size());
			for(DriversHistory getDriver : driver.getDriverHistory()) {
				System.out.println("Driver Name : " + getDriver.getName());
			}
			driverHistory.setVersion(driver.getDriverHistory().size() + 1);
		}
		
		Car car = carRepo.findByDrivers(driver);
		
		driverHistory.setDriverId(driver);
		driverHistory.setName(driver.getName());
		driverHistory.setPassword(driver.getPassword());
		driverHistory.setPhone(driver.getPhone());
		driverHistory.setNRC(driver.getNRC());
		driverHistory.setDriverLicense(driver.getDriverLicense());
		driverHistory.setAddress(driver.getAddress());
		driverHistory.setDateOfBrith(driver.getDateOfBrith());
		driverHistory.setTownship(driver.getTownship().getName());
		driverHistory.setCarNo(car.getCarNo());
		driverHistory.setCarLicense(car.getCarLicense());
		driverHistory.setAircon(car.isAircon());
		driverHistory.setCarName(car.getCarName().getName());
		
		driverHistoryRepo.save(driverHistory);
	}
	
	
}














