package com.jdc.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jdc.car.model.form.MemberForm;
import com.jdc.car.model.repo.MembersRepo;

@Service
public class MemberService {

	@Autowired
	private MembersRepo memberRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public String create(MemberForm form) {
		memberRepo.save(form.entity(passwordEncoder));
		return "Member is created successfully";
	}
}
