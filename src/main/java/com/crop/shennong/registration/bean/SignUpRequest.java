package com.crop.shennong.registration.bean;

import com.crop.shennong.registration.validator.PasswordMatches;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@PasswordMatches
public class SignUpRequest {
    @NotEmpty
    private String phone;

    @NotEmpty
    private String password;

    @NotEmpty
    private String matchingPassword;

    @NotEmpty
    private String displayName;
}
