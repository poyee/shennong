package com.crop.shennong.security.jwt;

import com.crop.shennong.bean.UserDto;
import lombok.Value;

@Value
public class JwtAuthenticationResponse {
	private String accessToken;
	private UserDto user;
}
