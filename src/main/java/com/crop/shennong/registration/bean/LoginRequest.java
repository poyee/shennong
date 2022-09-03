package com.crop.shennong.registration.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {
	@NotBlank
	private String phone;

	@NotBlank
	private String password;
}
