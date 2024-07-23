package com.example.rent_module.dto;

import lombok.Data;

@Data
public class RentReadDto {

    //    private String token or login;
    private Long id;
    private String city;
    private String street;
    private String house;
    private Integer number;
    private Boolean status;
    private Integer price;
}
