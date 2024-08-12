package com.example.rent_module.dto;

import com.example.rent_module.entity.Address;
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
//    private Address address;

}