package com.cthu.car.model.form;

import jakarta.validation.constraints.NotBlank;

public record LoginForm(
		@NotBlank(message = "Enter username")
		String username,
		@NotBlank(message = "Enter password")
		String password
		) {

}
