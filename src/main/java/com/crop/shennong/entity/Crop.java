package com.crop.shennong.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Crop {
    @Id
    private Long uid;
    private String cname;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plv1")
    private CropCategory category;
}
