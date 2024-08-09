package com.example.rent_module.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "booking")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time")
    private LocalDate startTime;

    @Column(name = "end_time")
    private LocalDate endTime;

    @Column(name = "days")
    private Integer days;

    @Column(name = "cost")
    private Integer cost;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserInfoEntity user;

    @OneToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;


}
