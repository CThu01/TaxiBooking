package com.cthu.car.model.output;

public record ApiResponse<T>(
		boolean status,
		T payload
		) {
	
	public static<T> ApiResponse<T> success(T payload) {
		return new ApiResponse<T>(true, payload);
	}

	public static<T> ApiResponse<T> fail(T payload){
		return new ApiResponse<T>(false, payload);
	}
	
}