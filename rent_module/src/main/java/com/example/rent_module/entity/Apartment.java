package com.example.rent_module.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "apartment")
@Data
public class Apartment {

    @Id
    @SequenceGenerator(name = "apartmentSequence", sequenceName = "apartment_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartmentSequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "price")
    private Integer price;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserInfoEntity userInfo;

}

