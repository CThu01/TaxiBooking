package com.cthu.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cthu.car.model.dto.DriverInfoDto;
import com.cthu.car.model.form.DriverForm;
import com.cthu.car.model.repo.DriversRepo;
import com.cthu.car.model.repo.TownshipRepo;
import com.cthu.car.utils.exceptions.ApiBusinessException;

@Service
public class DriverService {

	@Autowired
	private DriversRepo driverRepo;
	
	@Autowired
	private TownshipRepo townshipRepo;

	public DriverInfoDto create(DriverForm form) {
		
		var driver = driverRepo.save(form.driverEntity(id -> townshipRepo.findById(id)
				.orElseThrow(() -> new ApiBusinessException("Invalid Township"))));
		
		return null;
	}
}
