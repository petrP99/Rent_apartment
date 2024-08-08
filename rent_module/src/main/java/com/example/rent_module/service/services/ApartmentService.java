package com.example.rent_module.service.services;


import com.example.rent_module.dto.BookingApartmentRequest;
import com.example.rent_module.entity.Apartment;

import java.util.Optional;

public interface ApartmentService {

    //по токену будет находить юзера, тк передавать токен в сам контроллер невозможно(сам юзер его не знает)
    String registerApartment(String token, String city, String street, Integer number, Integer price);

    String getIntegration();

    BookingApartmentRequest findById(Long id);
}
