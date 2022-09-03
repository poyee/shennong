package com.crop.shennong.bean;

import lombok.Value;

import java.util.List;

@Value
public class UserDto {
    private Long id;
    private String displayName;
    private String phone;
    private List<String> roles;
}
