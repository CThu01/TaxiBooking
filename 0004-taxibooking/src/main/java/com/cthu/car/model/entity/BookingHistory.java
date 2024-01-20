package com.cthu.car.model.entity;

import java.time.Duration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionHistoryId;
	
	@ManyToOne
	@JoinColumn(nullable = false,name = "booking_id")
	private Bookings bookingId;
	
	@Column(nullable = false,name = "from_location")
	private String fromLocation;
	
	@Column(nullable = false,name = "to_location")
	private String toLocation;
	
	@Column(nullable = false,name = "payment_method")
	private String paymentMethod;
	
	@Column(nullable = false,name = "amount")
	private int amount;
	
	@Column(nullable = false,name = "duration")
	private Duration duration;
	
	@Column(nullable = false,name = "version")
	private int version;
	
}
