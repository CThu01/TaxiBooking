package com.cthu.car.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class BookingHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionHistoryId;
	
	@ManyToOne
	@JoinColumn(nullable = false,name = "booking_id")
	private Bookings bookingId;
	
	@Embedded
	@Column(nullable = false,name = "from_location")
	private GeoLocation fromLocation;
	
	@Embedded
	@Column(nullable = false,name = "to_location")
	private GeoLocation toLocation;
	
	@Column(nullable = false,name = "payment_method")
	private String paymentMethod;
	
	@Column(nullable = false,name = "amount")
	private int amount;
	
	@Temporal(TemporalType.TIME)
	@Column(nullable = false,name = "duration")
	private Date duration;
	
}
