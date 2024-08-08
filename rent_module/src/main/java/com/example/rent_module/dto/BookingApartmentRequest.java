package com.example.rent_module.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookingApartmentRequest {

    private String message;
    private ApartmentDto apartmentDto;
}
