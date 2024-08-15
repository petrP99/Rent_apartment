package com.example.rent_module.service;

import com.example.rent_module.dto.BookingApartmentRequest;
import com.example.rent_module.dto.BookingReadDto;
import com.example.rent_module.dto.ProductCreateDto;
import com.example.rent_module.dto.RentReadDto;
import com.example.rent_module.entity.Apartment;
import com.example.rent_module.entity.Booking;
import com.example.rent_module.entity.Product;
import com.example.rent_module.entity.UserInfoEntity;
import com.example.rent_module.exception.ApartmentException;
import com.example.rent_module.mapper.BookingMapper;
import com.example.rent_module.mapper.ProductMapper;
import com.example.rent_module.mapper.RentDtoMapper;
import com.example.rent_module.repository.ApartmentRepository;
import com.example.rent_module.repository.BookingRepository;
import com.example.rent_module.repository.ProductRepository;
import com.example.rent_module.service.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final ApartmentRepository apartmentRepository;
    private final BookingRepository bookingRepository;
    private final ProductRepository productRepository;
    private final RentDtoMapper rentDtoMapper;
    private final BookingMapper bookingMapper;
    private final ProductMapper productMapper;

    // TODO: 10.08.2024   рассмотреть вариант сделать метод воид
    public BookingApartmentRequest checkApartmentById(Long id) {
        Apartment apartment = apartmentRepository.findById(id).orElseThrow(() -> new ApartmentException("Апартаменты не доступны", 10));
        RentReadDto dto = rentDtoMapper.toDto(apartment);
        return new BookingApartmentRequest("Апартаменты доступны для брониварвания", dto);
    }

    @Override
    public BookingReadDto bookingApartment(UserInfoEntity user, Long apartmentId, LocalDate startTime, LocalDate endTime, ProductCreateDto productDto) {
        BookingApartmentRequest bookingApartmentRequest = checkApartmentById(apartmentId);
        RentReadDto rentReadDto = bookingApartmentRequest.getRentReadDto();
        Apartment apartment = apartmentRepository.findById(apartmentId).orElseThrow(() -> new ApartmentException("Апартаменты не доступны", 10));
        Product product = productRepository.save(productMapper.toEntity(productDto));
        int days = (int) ChronoUnit.DAYS.between(startTime, endTime);
        Booking savedBooking = bookingRepository.save(Booking.builder()
                .startTime(startTime)
                .endTime(endTime)
                .days(days)
                .cost(rentReadDto.getPrice() * days)
                .user(user)
                .apartment(apartment)
                .product(product)
                .build());

        apartment.setStatus(false);
        apartmentRepository.save(apartment);
        try {
            // TODO: 14.08.2024 запрос в сервис продукт должен быть тут
        } catch (Exception e) {
            // TODO: 14.08.2024 в случае отсутствия ответа от продукта, то дто пробрасываем в топик кафки
        }
        return bookingMapper.toDto(savedBooking);
    }

    @Override
    public BookingReadDto getBooking(Long id) {
        return bookingMapper.toDto(bookingRepository.findById(id).orElseThrow());
    }
}
