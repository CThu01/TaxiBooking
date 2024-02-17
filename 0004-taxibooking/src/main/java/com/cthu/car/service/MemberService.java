package com.cthu.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.cthu.car.model.dto.MemberInfoDto;
import com.cthu.car.model.entity.Members;
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
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
		

	public String create(MemberForm form) {
		
		Members member = memberRepo.save(form.entity(id -> townshipRepo.findById(id)
				      	.orElseThrow(() -> new ApiBusinessException("Invalid Township Id"))));
		
		eventPublisher.publishEvent(member);
		
		return "Member is created successfully";
	}


	public MemberInfoDto getProfile(int id) {
		
		var member = memberRepo.findById(id).orElse(null);
		
		if(null == member) {
			throw new ApiBusinessException("Member doesn't exit");
		}
		Members members = new Members();
		
		return members.getMemberInfoDto(member);
	}

	public MemberInfoDto profileUpdate(int id, MemberForm form) {
		
		var updatedMember = memberRepo.save(form.updateEntity(id,profileId -> townshipRepo.findById(id)
				.orElseThrow(() -> new ApiBusinessException("Member doesn't exit"))));
		
		Members members = new Members();
		
		eventPublisher.publishEvent(updatedMember);
		
		return members.getMemberInfoDto(updatedMember);
	}


	
}






