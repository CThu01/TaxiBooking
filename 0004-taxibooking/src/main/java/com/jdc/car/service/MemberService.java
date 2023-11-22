package com.jdc.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.car.model.form.MemberForm;
import com.jdc.car.model.repo.MembersRepo;

@Service
public class MemberService {

	@Autowired
	private MembersRepo memberRepo;
	

	public String create(MemberForm form) {
		memberRepo.save(form.entity());
		return "Member is created successfully";
	}
}
