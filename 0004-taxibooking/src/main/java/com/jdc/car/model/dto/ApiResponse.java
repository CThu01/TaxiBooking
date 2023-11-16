package com.jdc.car.model.dto;

public record ApiResponse<T>(
		boolean status,
		T payload
		) {
	
	public static<T> ApiResponse<T> success(T payload) {
		return new ApiResponse<T>(true, payload);
	}

}
