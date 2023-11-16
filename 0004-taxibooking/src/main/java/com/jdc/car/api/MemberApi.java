package com.jdc.car.api;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.car.model.dto.MemberInfoDto;
import com.jdc.car.model.form.MemberForm;

@RestController
@RequestMapping("member")
public class MemberApi {

	public MemberInfoDto create(@Validated MemberForm form,BindingResult result) {
		return null;
	}
	
	
	
}
