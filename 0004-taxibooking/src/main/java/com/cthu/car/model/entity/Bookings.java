package com.cthu.car.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.locationtech.jts.geom.Point;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	@OneToOne
	@JoinColumn(nullable = false,name = "member_id")
	private Members memberId;
	
	@OneToOne
	@JoinColumn(nullable = false,name = "driver_id")
	private Drivers driverId;
	
	@OneToMany(mappedBy = "bookingId")
	private List<BookingHistory> bookingHistory;
	
	private int stars;
	
	@Column(nullable = false,name = "pickup_point")
	private Point pickupPoint;
	
	@Column(nullable = false,name = "destination_point")
	private Point destinationPoint;
	
	@Column(nullable = false,name = "booking_time")
	private LocalDateTime bookingTime;
	
	@Column(nullable = false,name = "departure_time")
	private LocalDateTime departureTime;
	
	@Column(nullable = false,name = "arrival_time")
	private LocalDateTime arrivalTime;
	
	@Column(nullable = false)
	private Status status;
	
	
	public enum Status{
		Completed,Pending,Cancelled
	}
	
	
}
