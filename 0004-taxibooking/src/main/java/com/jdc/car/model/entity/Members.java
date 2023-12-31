package com.jdc.car.model.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.CascadeType;
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
public class Members {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginId;
	@Column(nullable = false)	
	private String name;
	@Column(nullable = false)	
	private String password;
	@Column(nullable = false)	
	private String phone;
	@Column(nullable = false)	
	private String NRC;
	@Column(nullable = false)	
	private String address;
	@Column(nullable = false)	
	private String userPhoto;
	@Temporal(TemporalType.DATE)
	private LocalDate dateOfBirth;

	private String email;

	@ManyToOne
	@JoinColumn(nullable = false)	
	private Township township;
	
	
}
