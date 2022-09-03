package com.crop.shennong.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Crop {
    @Id
    private long uid;
    private String cname;

    @OneToOne
    @JoinColumn(name = "plv1")
    private CropCategory category;
}
