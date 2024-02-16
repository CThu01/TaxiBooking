package com.cthu.car.model.entity;

import java.time.LocalDate;
import java.util.List;

import com.cthu.car.model.dto.MemberInfoDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
//	@Column(nullable = false)	
	private String userPhoto;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	private String email;
	
	@OneToMany(mappedBy = "memberId")
	private List<MembersHistory> memberHistory;

	@ManyToOne
	@JoinColumn(nullable = false,name = "township")	
	private Township township;
	
	public MemberInfoDto getMemberInfoDto(Members member) {
		return new MemberInfoDto(
				member.getLoginId(), 
				member.getName(), 
				member.getPhone(),
				member.getNRC(),
				member.getAddress(),
				member.getDateOfBirth(),
				member.getUserPhoto());
	}

	
	
}
