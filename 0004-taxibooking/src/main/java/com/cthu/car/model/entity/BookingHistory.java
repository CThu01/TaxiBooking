package com.cthu.car.model.entity;

import java.util.Date;

import org.locationtech.jts.geom.Point;

import jakarta.persistence.Column;
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
	@JoinColumn(nullable = false)
	private Bookings bookingId;
	
	@Column(nullable = false)
	private Point fromLocation;
	@Column(nullable = false)
	private Point toLocation;
	@Column(nullable = false)
	private String paymentMethod;
	@Column(nullable = false)
	private int amount;
	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date duration;
	
}
