package com.cthu.car.model.output;

import java.util.List;

public record ErrorResponse(
		errorType type,
		List<String> message
		) {

	public enum errorType{
		BUSINESS,VALIDATION,PLATFORM
	}
}
