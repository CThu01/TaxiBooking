package com.cthu.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cthu.car.model.form.MemberForm;
import com.cthu.car.model.repo.MembersRepo;
import com.cthu.car.model.repo.TownshipRepo;
import com.cthu.car.utils.exceptions.ApiBusinessException;

@Service
public class MemberService {

	@Autowired
	private MembersRepo memberRepo;
	
	@Autowired
	private TownshipRepo townshipRepo;
	

	public String create(MemberForm form) {
		memberRepo.save(form.entity(id -> townshipRepo.findById(id)
				      	.orElseThrow(() -> new ApiBusinessException("Invalid Township Id"))));
		return "Member is created successfully";
	}
}
