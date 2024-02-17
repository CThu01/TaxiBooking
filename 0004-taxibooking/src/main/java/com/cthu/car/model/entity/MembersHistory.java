package com.cthu.car.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembersHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberHistoryId;
	
	@ManyToOne
	@JoinColumn(nullable = false,name = "member_id")
	private Members memberId;
	
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
	private String township;
	
//	@Column(nullable = false,name = "user_photo")	
	private String userPhoto;
	
	@Column(nullable = false)
	private int version;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	
	private String email;
}
