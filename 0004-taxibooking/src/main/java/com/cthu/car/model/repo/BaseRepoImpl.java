package com.cthu.car.model.repo;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class BaseRepoImpl<T, ID> extends SimpleJpaRepository<T, ID>
	implements BaseRepo<T, ID>{

	private EntityManager em;
	
	public BaseRepoImpl(JpaEntityInformation<T,?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
	}

	@Override
	public <R> Page<R> findAll(
			Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc,
			Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc,
			int page,int size){
		
		var count = em.createQuery(countFunc.apply(em.getCriteriaBuilder()))
				.getSingleResult();
		var content = em.createQuery(queryFunc.apply(em.getCriteriaBuilder()))
				.setFirstResult(page * size)
				.setMaxResults(size)
				.getResultList();
		return new PageImpl<R>(content, PageRequest.of(page, size), count);

		
	}
}
