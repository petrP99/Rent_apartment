package com.example.rent_module.controller;

import static com.example.rent_module.controller.PathConstants.INTEGRATION_PRODUCT;
import static com.example.rent_module.controller.PathConstants.REGISTRATION_APARTMENT;
import com.example.rent_module.dto.BookingReadDto;
import com.example.rent_module.dto.ProductCreateDto;
import com.example.rent_module.dto.RentCreateDto;
import com.example.rent_module.entity.UserInfoEntity;
import com.example.rent_module.service.ValidTokenServiceImpl;
import com.example.rent_module.service.services.ApartmentService;
import com.example.rent_module.service.services.BookingService;
import static java.util.Objects.isNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class RentApartmentController {

    private final ValidTokenServiceImpl validTokenService;
    private final ApartmentService apartmentService;
    private final BookingService bookingService;

    @PostMapping(REGISTRATION_APARTMENT)
    public String registration(@RequestHeader String token, @RequestBody RentCreateDto createDto) {
        validTokenService.checkValidToken(token);
        return apartmentService.registerApartment(token, createDto.getCity(), createDto.getStreet(), createDto.getNumber(), createDto.getPrice());
    }

    @GetMapping("/get/{id}")
    public BookingReadDto bookingApartment(@PathVariable Long id) {
        return bookingService.getBooking(id);
    }

    @PostMapping(INTEGRATION_PRODUCT)
    public BookingReadDto bookingApartment(
            @RequestParam(required = false) LocalDate startTime,
            @RequestParam(required = false) LocalDate endTime,
            @RequestParam Long apartmentId,
            @RequestHeader(required = false) String token,
            @RequestBody ProductCreateDto productDto) {

        UserInfoEntity user = validTokenService.checkValidToken(token);
        if (isNull(startTime) && isNull(endTime)) {
            throw new RuntimeException("Не указаны даты заезда и выезда");
        }
        return bookingService.bookingApartment(user, apartmentId, startTime, endTime, productDto);

    }

}
