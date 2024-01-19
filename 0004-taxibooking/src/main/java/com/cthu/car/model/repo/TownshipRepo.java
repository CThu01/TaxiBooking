package com.cthu.car.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.cthu.car.model.entity.Township;

@Repository
public interface TownshipRepo extends JpaRepositoryImplementation<Township, Integer>{

}
