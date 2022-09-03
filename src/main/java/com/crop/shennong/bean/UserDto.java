package com.crop.shennong.bean;

import lombok.Value;

import java.util.List;

@Value
public class UserDto {
    private long id;
    private String displayName;
    private String phone;
    private List<String> roles;
}
