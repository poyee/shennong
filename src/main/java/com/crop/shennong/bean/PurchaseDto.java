package com.crop.shennong.bean;

import lombok.Data;

@Data
public class PurchaseDto {
    private Integer id;
    private Long cropUid;
    private Long userId;
    private Double price;
    private String unit;
    private String createdTime;
}
