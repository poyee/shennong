package com.crop.shennong.bean;

import lombok.Data;

import java.util.List;

@Data
public class HistoryPurchase {
    private Long userId;
    private String phone;
    private String userName;
    private Long cropId;
    private String cropName;
    private List<Item> items;

    @Data
    public static class Item {
        private Double price;
        private String createdTime;
        private String unit;
    }
}
