package com.example.rent_module.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingReadDto {

    private Long id;
    private LocalDate startTime;
    private LocalDate endTime;
    private Integer days;
    private Integer cost;
    private UserReadDto user;
    private ApartmentReadDto apartment;
    private ProductReadDto product;
}
