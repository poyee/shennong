package com.crop.shennong.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class CropCategory {
    @Id
    private int plv1;
    private String name;
}
