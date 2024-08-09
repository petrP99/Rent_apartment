package com.example.rent_module.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cleaning")
    private Boolean cleaning;

    @Column(name = "breakfast")
    private Boolean breakfast;

    @Column(name = "dinner")
    private Boolean dinner;

    @Column(name = "bar")
    private Boolean bar;

    @Column(name = "transfer")
    private Boolean transfer;

    @Column(name = "insurance")
    private Boolean insurance;


}
