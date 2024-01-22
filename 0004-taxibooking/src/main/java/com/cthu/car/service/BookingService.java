package com.cthu.car.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cthu.car.model.dto.BookingHistoryInfoDto;
import com.cthu.car.model.dto.BookingInfoDto;
import com.cthu.car.model.entity.BookingHistory;
import com.cthu.car.model.entity.Bookings;
import com.cthu.car.model.form.BookingForm;
import com.cthu.car.model.form.BookingSearchForm;
import com.cthu.car.model.repo.BookingHistoryRepo;
import com.cthu.car.model.repo.BookingsRepo;
import com.cthu.car.model.repo.DriversRepo;
import com.cthu.car.model.repo.MembersRepo;
import com.cthu.car.utils.exceptions.ApiBusinessException;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;


@Service
public class BookingService {
	
	@Autowired
	private MembersRepo membersRepo;
	
	@Autowired
	private DriversRepo driverRepo;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private BookingHistoryRepo bookingHistoryRepo;
	
	@Autowired
	private BookingsRepo bookingsRepo;
		
	public BookingInfoDto create(BookingForm form) {
		
		Bookings booking = bookingsRepo.save(form.getBooking(
					id -> membersRepo.findById(id).orElseThrow(() -> new ApiBusinessException("Invalid Member Id"))
				   ,id -> driverRepo.findById(id).orElseThrow(() -> new ApiBusinessException("Invalid Driver Id"))
				   ));
		
		eventPublisher.publishEvent(booking);
		
		return getBookingInfoDto(booking,"create",0);
	}
	
	
	public List<BookingHistoryInfoDto> getAllBookingHistory(int id) {

		List<BookingHistoryInfoDto> bookingHistoryList = new ArrayList<BookingHistoryInfoDto>();
		List<BookingHistory> bookingHistoryResult = bookingHistoryRepo.findAll();
		
		for(BookingHistory bookingHistory : bookingHistoryResult) {
			bookingHistoryList.add(getInfoDto(bookingHistory,id)); 
		}
		return bookingHistoryList;
	}
	
	private BookingHistoryInfoDto getInfoDto(BookingHistory historyResult,int id) {
		
		return new BookingHistoryInfoDto(
				getBookingInfoDto(historyResult.getBookingId(),"member",id), 
				historyResult.getFromLocation(),
				historyResult.getToLocation(),
				historyResult.getPaymentMethod(), 
				historyResult.getAmount(),
				formattedDuration(historyResult.getDuration()), 
				historyResult.getVersion());
	}
	
	private String formattedDuration(Duration duration) {
		
		long hours = duration.toHours();
		long minutes = duration.toMinutes();
		long seconds = duration.toSeconds(); 
		return String.format("%02d:%02d:%02d", hours,minutes,seconds);
	}

	
	private BookingInfoDto getBookingInfoDto(Bookings booking,String forWhat,int id) {
		
		if(forWhat.equals("member")) {

			return new BookingInfoDto(
					memberService.getProfile(id), 
					driverService.getProfileById(booking.getDriverId().getLoginId()), 
					booking.getPrice(), 
					booking.getPaymentMethod(),
					booking.isAircon(), 
					booking.getPickupPoint(),
					booking.getDestinationPoint(), 
					booking.getDepartureTime().toString(), 
					booking.getArrivalTime().toString(), 
					booking.getStars(),
					booking.getStatus().toString());

		} else if (forWhat.equals("driver")) {

			return new BookingInfoDto(
					memberService.getProfile(booking.getMemberId().getLoginId()), 
					driverService.getProfileById(id), 
					booking.getPrice(), 
					booking.getPaymentMethod(),
					booking.isAircon(), 
					booking.getPickupPoint(),
					booking.getDestinationPoint(), 
					booking.getDepartureTime().toString(), 
					booking.getArrivalTime().toString(), 
					booking.getStars(),
					booking.getStatus().toString());

		}
				
		return new BookingInfoDto(
					memberService.getProfile(booking.getMemberId().getLoginId()), 
					driverService.getProfileById(booking.getDriverId().getLoginId()), 
					booking.getPrice(), 
					booking.getPaymentMethod(),
					booking.isAircon(), 
					booking.getPickupPoint(),
					booking.getDestinationPoint(), 
					booking.getDepartureTime().toString(), 
					booking.getArrivalTime().toString(), 
					booking.getStars(),
					booking.getStatus().toString());
	}



	
	@Transactional(readOnly = true)
	public Page<BookingHistoryInfoDto> search(BookingSearchForm form, int page, int size) {
		
		Function<CriteriaBuilder, CriteriaQuery<BookingHistoryInfoDto>> queryFunc = 
				cb -> {
					var query = cb.createQuery(BookingHistoryInfoDto.class);
					var root = query.from(BookingHistory.class);
					BookingHistoryInfoDto.select(query,root);
					query.where(form.where(cb,root));
					return query;
				};
				
		Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc = 
				cb -> {
					var query = cb.createQuery(Long.class);
					var root = query.from(BookingHistory.class);
					query.select(cb.count(root.get("transactionHistoryId")));
					query.where(form.where(cb, root));
					return query;
				};
		return bookingHistoryRepo.findAll(queryFunc,countFunc,page,size);
	}
	
	
	
		

}














