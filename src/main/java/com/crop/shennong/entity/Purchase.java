package com.crop.shennong.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "purchase")
@EntityListeners(AuditingEntityListener.class)
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double price;

    @OneToOne
    @JoinColumn(name = "crop_uid")
    private Crop crop;

    @OneToOne
    @JoinColumn(name="unit")
    private Unit unit;

    @OneToOne
    @CreatedBy
    @JoinColumn(name="user_id")
    private User user;

    @CreatedDate
    @Column(name = "created_time")
    private LocalDateTime createdTime;
}
