package com.example.rent_module.dto;

import lombok.Data;

@Data
public class RentCreateDto {

    private String city;
    private String street;
    private String house;
    private Integer number;
    private Integer price;
}
