package com.example.rent_module.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApartmentReadDto {

    private Long id;
    private String city;
    private String street;
    private String house;
    private Integer number;
    private Integer price;
    private String address;
}
