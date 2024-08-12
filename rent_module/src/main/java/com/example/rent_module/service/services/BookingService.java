package com.example.rent_module.service.services;

import com.example.rent_module.dto.BookingReadDto;
import com.example.rent_module.dto.ProductCreateDto;
import com.example.rent_module.entity.UserInfoEntity;

import java.time.LocalDate;

public interface BookingService {

    BookingReadDto bookingApartment(UserInfoEntity user, Long apartmentId, LocalDate startTime, LocalDate endTime, ProductCreateDto productDto);

    BookingReadDto getBooking(Long id);
}
