package com.example.rent_module.mapper;

import com.example.rent_module.dto.ApartmentDto;
import com.example.rent_module.dto.RentReadDto;
import com.example.rent_module.entity.Apartment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApartmentDtoMapper {

    @Mapping(target = "city", source = "address.city")
    @Mapping(target = "street", source = "address.street")
    @Mapping(target = "house", source = "address.house")
    @Mapping(target = "number", source = "apartment.number")
    @Mapping(target = "status", source = "apartment.status")
    @Mapping(target = "price", source = "apartment.price")
    ApartmentDto toDto(Apartment apartment);


}
