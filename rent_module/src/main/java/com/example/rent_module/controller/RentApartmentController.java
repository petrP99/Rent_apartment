package com.example.rent_module.controller;

import static com.example.rent_module.controller.PathConstants.INTEGRATION_PRODUCT;
import static com.example.rent_module.controller.PathConstants.REGISTRATION_APARTMENT;

import com.example.rent_module.dto.BookingApartmentRequest;
import com.example.rent_module.dto.RentCreateDto;
import com.example.rent_module.entity.UserInfoEntity;
import com.example.rent_module.service.ValidTokenServiceImpl;
import com.example.rent_module.service.services.ApartmentService;

import static java.util.Objects.isNull;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class RentApartmentController {

    private final ValidTokenServiceImpl validTokenService;
    private final ApartmentService apartmentService;

    @PostMapping(REGISTRATION_APARTMENT)
    public String registration(@RequestHeader String token, @RequestBody RentCreateDto createDto) {
        validTokenService.checkValidToken(token);
        return apartmentService.registerApartment(token, createDto.getCity(), createDto.getStreet(), createDto.getNumber(), createDto.getPrice());
    }

    @GetMapping(INTEGRATION_PRODUCT)
    public String bookingApartment(@RequestParam(required = false) LocalDate startTime,
                                                       @RequestParam(required = false) LocalDate endTime,
                                                       @RequestParam Long apartmentId,
                                                       @RequestHeader(required = false) String token) {

        UserInfoEntity user = validTokenService.checkValidToken(token);
        if (isNull(startTime) && isNull(endTime)) {
            throw new RuntimeException("Не указаны даты заезда и выезда");
        }
        apartmentService.rentApartment(apartmentId, startTime, endTime);

        return null;
    }

}
