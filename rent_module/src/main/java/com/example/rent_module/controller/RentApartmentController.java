package com.example.rent_module.controller;

import static com.example.rent_module.controller.PathConstants.REGISTRATION_APARTMENT;
import com.example.rent_module.dto.RentCreateDto;
import com.example.rent_module.service.ValidTokenServiceImpl;
import com.example.rent_module.service.services.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RentApartmentController {

    private final ValidTokenServiceImpl validTokenService;
    private final ApartmentService apartmentService;


    @PostMapping(REGISTRATION_APARTMENT)
    public String registration(@RequestHeader String token, @RequestBody RentCreateDto createDto) { //добавить все поля с адреса+апартмент
        validTokenService.checkValidToken(token);
        return apartmentService.registerApartment(token, createDto.getHotelName());
    }
}
