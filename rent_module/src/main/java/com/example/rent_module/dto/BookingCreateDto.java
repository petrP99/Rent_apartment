package com.example.rent_module.dto;

import com.example.rent_module.entity.Apartment;
import com.example.rent_module.entity.Product;
import com.example.rent_module.entity.UserInfoEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingCreateDto {

    private LocalDate startTime;
    private LocalDate endTime;
    private Integer days;
    private Integer cost;
    private UserInfoEntity user;
    private Apartment apartment;
    private Product product;

}
