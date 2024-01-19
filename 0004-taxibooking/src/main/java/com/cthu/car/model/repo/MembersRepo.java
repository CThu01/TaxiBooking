package com.cthu.car.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.cthu.car.model.entity.Members;

@Repository
public interface MembersRepo extends JpaRepositoryImplementation<Members, Integer>{

}
