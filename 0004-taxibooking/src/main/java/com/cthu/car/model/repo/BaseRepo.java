package com.cthu.car.model.repo;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@NoRepositoryBean
public interface BaseRepo<T,ID> extends JpaRepositoryImplementation<T, ID>{

	<R> Page<R> findAll(
			Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc,
			Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc,
			int page,int size);
}
