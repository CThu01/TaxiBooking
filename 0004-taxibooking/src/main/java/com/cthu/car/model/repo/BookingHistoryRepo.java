package com.cthu.car.model.repo;

import org.springframework.stereotype.Repository;

import com.cthu.car.model.entity.BookingHistory;

@Repository
public interface BookingHistoryRepo extends BaseRepo<BookingHistory, Integer>{

	
//	public default <R> Page<R> findAll(
//			Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc,
//			Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc,
//			int page,int size){
//		
//		var count = em.createQuery(countFunc.apply(em.getCriteriaBuilder()))
//				.getSingleResult();
//		var content = em.createQuery(queryFunc.apply(em.getCriteriaBuilder()))
//				.setFirstResult(page * size)
//				.setMaxResults(size)
//				.getResultList();
//		return new PageImpl<R>(content, PageRequest.of(page, size), count);
//
//	}


}
