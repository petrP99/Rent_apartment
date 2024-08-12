package com.example.rent_module.mapper;

import com.example.rent_module.dto.BookingCreateDto;
import com.example.rent_module.dto.BookingReadDto;
import com.example.rent_module.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookingMapper {

    Booking toEntity(BookingCreateDto dto);

    @Mapping(target = "apartment.city", source = "apartment.address.city")
    @Mapping(target = "apartment.street", source = "apartment.address.street")
    @Mapping(target = "apartment.house", source = "apartment.address.house")
    BookingReadDto toDto(Booking booking);

}
