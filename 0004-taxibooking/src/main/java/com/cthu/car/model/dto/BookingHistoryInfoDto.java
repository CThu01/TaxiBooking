package com.cthu.car.model.dto;

import com.cthu.car.model.entity.BookingHistory;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingHistoryInfoDto {
	
		private BookingInfoDto bookingInfoDto;
		private String fromLocation;
		private String toLocation;
		private String paymentMethod;
		private int amount;
		private String duration;
		private int version;
		
		public static void select(CriteriaQuery<BookingHistory> query, Root<BookingHistory> root) {
			
			query.multiselect(
					root.get("transactionHistoryId"),
					root.get("bookingId"),
					root.get("fromLocation"),
					root.get("toLocation"),
					root.get("paymentMethod"),
					root.get("amount"),
					root.get("duration"),
					root.get("version")
					);
		}		 

}
